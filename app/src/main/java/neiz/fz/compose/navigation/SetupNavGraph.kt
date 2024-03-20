package neiz.fz.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import neiz.fz.compose.view.home.HomeScreen
import neiz.fz.compose.view.login.LoginScreen
import neiz.fz.compose.view.on_boarding.OnBoardingScreen
import neiz.fz.compose.view.welcome.WelcomeScreen

@Composable
fun SetupNavGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ){
        composable(Screen.Welcome.route){
            WelcomeScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.OnBoarding.route)
                }
            )
        }
        composable(Screen.OnBoarding.route){
            OnBoardingScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(Screen.Login.route){
            LoginScreen(
                onNavigateHome = {
                    navController.popBackStack()
                    navController.navigate(route = Screen.Home.route)
                }
            )
        }

        composable(Screen.Home.route){
            HomeScreen()
        }
    }
}