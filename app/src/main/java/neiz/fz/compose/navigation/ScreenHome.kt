package neiz.fz.compose.navigation

sealed class ScreenHome (val route:String){

    object Dish : ScreenHome(route = "dish_screen")

    object Search : ScreenHome(route = "search_screen")

    object Setting : ScreenHome(route = "setting_screen")

    object DishDetail : ScreenHome(route = "dishDetail_screen")


}