package com.app.recetasEIngredientes.navegacion

sealed class Routes(val ruta: String) {


    // pantallas del login
    object Login : Routes("Login")

    object CreateAccount : Routes("CreateAccount")


    // pantallas del menu prinicipal
    object MenuPrincipal : Routes("MainMenu")

    // rutas que son parte de minutas navigator
    object ListadoMinutas : Routes("ListadoMinutas")

    object NuevaMinuta : Routes("NuevaMinuta?minutaId={minutaId}") {
        fun conParametro(minutaId: Int = 0) = "NuevaMinuta?minutaId=$minutaId"
        fun sinParametro() = "NuevaMinuta?minutaId=0"
    }


    // stack de recetas
    object ListadoRecetas : Routes("ListadoRecetas")
    object NuevaReceta : Routes("NuevaReceta?recetaId={recetaId}") {
        fun conParametro(recetaId: Int) = "NuevaReceta?recetaId=$recetaId"
        fun sinParametro() = "NuevaReceta?recetaId=0"
    }


    // stack de perfil
    object Perfil : Routes("Perfil")


}