import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.recetasEIngredientes.mainMenu.perfil.PerfilView
import com.app.recetasEIngredientes.mainMenu.recetas.RecetasView
import com.app.recetasEIngredientes.navegacion.MinutasNavigator
import com.app.recetasEIngredientes.navegacion.Routes

@Composable
fun MainMenuNavigator(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.MINUTAS_NAVIGATOR,
    ) {

        composable(route = Routes.MINUTAS_NAVIGATOR) {
            MinutasNavigator()
        }

        composable(route = Routes.RECETAS) {
            RecetasView()
        }
        composable(route = Routes.PERFIL) {
            PerfilView()
        }

    }
}