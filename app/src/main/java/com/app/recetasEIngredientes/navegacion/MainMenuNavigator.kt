import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasView
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.mainMenu.perfil.PerfilView
import com.app.recetasEIngredientes.mainMenu.recetas.RecetasView
import com.app.recetasEIngredientes.navegacion.Routes

@Composable
fun MainMenuNavigator(
    navControllerMenu: NavHostController,
    listadoMinutasVM: ListadoMinutasViewModel,
) {


    NavHost(
        navController = navControllerMenu,
        startDestination = Routes.LISTADO_MINUTAS,
    ) {

        composable(route = Routes.LISTADO_MINUTAS) {
            ListadoMinutasView(listadoMinutasVM)
        }

        composable(route = Routes.RECETAS) {
            RecetasView()
        }
        composable(route = Routes.PERFIL) {
            PerfilView()
        }

    }
}