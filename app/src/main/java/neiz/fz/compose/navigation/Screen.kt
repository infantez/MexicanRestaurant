package neiz.fz.compose.navigation

// Jerarquías cerradas
sealed class Screen (val route:String){

    object Welcome : Screen(route = "welcome_screen")
    object OnBoarding : Screen(route = "onboarding_screen")
    object Login : Screen(route = "login_screen")

    object Home : Screen(route = "home_screen")

}