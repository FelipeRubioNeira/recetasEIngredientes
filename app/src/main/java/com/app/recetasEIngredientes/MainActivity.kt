package com.app.recetasEIngredientes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.app.recetasEIngredientes.ui.theme.RecetasEIngredientesTheme
import com.app.recetasEIngredientes.login.LoginView
import com.app.recetasEIngredientes.mainMenu.MainMenuView
import com.app.recetasEIngredientes.navegacion.Navigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RecetasEIngredientesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    // lo primero que hacemos en iniciar con el navigation
                    Navigation()

                }
            }
        }
    }
}
