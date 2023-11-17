package com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.navegacion.Routes
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("facts/random")
    suspend fun factsRandom(): Response<JsonObject>
}

@Composable
fun ListadoMinutasView(navControllerPrincipal: NavController) {

    var texto by remember { mutableStateOf("Cargando...") }

    // es como el useEffect en react
    LaunchedEffect(Unit) {

        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val ApiService = retrofit.create(ApiService::class.java)
            val response = ApiService.factsRandom()

            if (response.isSuccessful) {
                val datos = response.body()
                texto = datos?.get("text")?.asString ?: "Error: Texto no encontrado"
            } else {
                texto = "Error en la llamada: ${response.code()}"
            }

        } catch (e: Exception) {
            texto = "Excepción: ${e.message}"
        }

    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text(text = texto, color = Colores.AZUL)

        BotonAgregarMinuta(navControllerPrincipal, Modifier.align(alignment = BottomEnd))
    }
}

@Composable
fun BotonAgregarMinuta(
    navControllerPrincipal: NavController,
    modifier: Modifier,
) {

    FloatingActionButton(
        containerColor = Colores.ROJO,
        contentColor = Colores.BLANCO,
        modifier = modifier.padding(16.dp),
        onClick = {
            navControllerPrincipal.navigate(Routes.NUEVA_MINUTA)
        }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}
