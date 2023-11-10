import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.mainMenu.calentario.CalendarioView
import com.app.recetasEIngredientes.mainMenu.perfil.PerfilView
import com.app.recetasEIngredientes.mainMenu.recetas.RecetasView
import com.app.recetasEIngredientes.navegacion.Routes

@Composable
fun NavigatorMainMenu(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.CALENDARIO
    ) {

        composable(route = Routes.CALENDARIO) {
            CalendarioView()
        }
        composable(route = Routes.RECETAS) {
            RecetasView()
        }
        composable(route = Routes.PERFIL) {
            PerfilView()
        }
    }
}