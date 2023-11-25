package com.app.recetasEIngredientes.common.API

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("facts/random")
    suspend fun factsRandom(): Response<JsonObject>
}

fun funcionRetrofil() {

    //var texto by remember { mutableStateOf("Cargando...") }
    // es como el useEffect en react
//    LaunchedEffect(Unit) {
//
//        try {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://cat-fact.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            val ApiService = retrofit.create(ApiService::class.java)
//            val response = ApiService.factsRandom()
//
//            if (response.isSuccessful) {
//                val datos = response.body()
//                texto = datos?.get("text")?.asString ?: "Error: Texto no encontrado"
//            } else {
//                texto = "Error en la llamada: ${response.code()}"
//            }
//
//        } catch (e: Exception) {
//            texto = "Texto por defecto" //"Excepción: ${e.message}"
//        }
//    }

}
