package neiz.fz.compose.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
           /* if (onBoardingRead() == true){
                LoginScreen(
                    onNavigateHome = {
                        navController.popBackStack()
                        navController.navigate(route = Screen.Home.route)
                    }
                )
            } else {
                // OnBoardingIsStart()*/
                WelcomeScreen(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screen.OnBoarding.route)
                    }
                )
            }
        // }
        composable(Screen.OnBoarding.route){
            // OnBoardingIsFinish()
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
/*
@Composable
private fun OnBoardingIsFinish(){
    val context = LocalContext.current
    val preferences = context.getSharedPreferences("PREFERENCES_TOKEN", Context.MODE_PRIVATE).edit()
    preferences.putBoolean("ON_BOARDING", true)
    preferences.apply()
}

@Composable
private fun OnBoardingIsStart(){
    val context = LocalContext.current
    val preferences = context.getSharedPreferences("PREFERENCES_TOKEN", Context.MODE_PRIVATE).edit()
    preferences.putBoolean("ON_BOARDING", false)
    preferences.apply()
}
@Composable
private fun onBoardingRead(): Boolean? {
    val context = LocalContext.current
    val preferencesRead = context.getSharedPreferences("PREFERENCES_TOKEN", 0)
    val show = preferencesRead.getBoolean("ON_BOARDING", true)
    return show
}

*/