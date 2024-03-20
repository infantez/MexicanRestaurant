package neiz.fz.compose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import neiz.fz.compose.view.dish.DishScreen
import neiz.fz.compose.view.dishdetail.DishDetailScreen
import neiz.fz.compose.view.search.SearchScreen
import neiz.fz.compose.view.settings.SettingsScreen

@Composable
fun SetupNavGraphHome(paddingValues: PaddingValues, navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = ScreenHome.Dish.route
    ){
        composable(ScreenHome.Dish.route){
            DishScreen(paddingValues = paddingValues)
        }

        composable(ScreenHome.Search.route){
            SearchScreen(paddingValues = paddingValues)
        }

        composable(ScreenHome.Setting.route){
            SettingsScreen(paddingValues = paddingValues)
        }

        composable(ScreenHome.DishDetail.route){
            DishDetailScreen(paddingValues = paddingValues)
        }

    }
}