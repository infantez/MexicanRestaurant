package neiz.fz.compose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import neiz.fz.compose.domain.model.Dish
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
            DishScreen(
                paddingValues = paddingValues,
                onSelectedItem = { dish ->
                    val dishJson = Gson().toJson(dish)
                    navController.navigate(ScreenHome.DishDetail.createRoute(dishJson))
                }
            )
        }

        composable(ScreenHome.Search.route){
            SearchScreen(paddingValues = paddingValues)
        }

        composable(ScreenHome.Setting.route){
            SettingsScreen(paddingValues = paddingValues)
        }

        composable(ScreenHome.DishDetail.route){
            val dishJson = it.arguments?.getString("dishJson")
            val dish = Gson().fromJson(dishJson, Dish::class.java)
            DishDetailScreen(paddingValues = paddingValues, dish = dish)
        }

    }
}