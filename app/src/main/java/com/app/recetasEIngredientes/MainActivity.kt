package com.app.recetasEIngredientes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.app.recetasEIngredientes.ui.theme.RecetasEIngredientesTheme
import com.app.recetasEIngredientes.login.LoginView
import com.app.recetasEIngredientes.mainMenu.MainMenuView
import com.app.recetasEIngredientes.navegacion.AppNavigator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RecetasEIngredientesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    // lo primero que hacemos en iniciar con el navigation
                    AppNavigator()

                }
            }
        }
    }
}
