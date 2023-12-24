import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasView
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.mainMenu.perfil.PerfilView
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.ListadoRecetasView
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.ListadoRecetasViewModel
import com.app.recetasEIngredientes.navegacion.Routes

@Composable
fun MainMenuNavigator(
    navControllerMenu: NavHostController,
    listadoMinutasVM: ListadoMinutasViewModel,
    listadoRecetasVM: ListadoRecetasViewModel
) {


    NavHost(
        navController = navControllerMenu,
        startDestination = Routes.ListadoRecetas.ruta
    ) {

        composable(route = Routes.ListadoRecetas.ruta) {
            ListadoRecetasView(listadoRecetasVM)
        }
        composable(route = Routes.ListadoMinutas.ruta) {
            ListadoMinutasView(listadoMinutasVM)
        }

        composable(route = Routes.Perfil.ruta) {
            PerfilView()
        }

    }
}