package neiz.fz.compose.view.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import neiz.fz.compose.navigation.ScreenHome
import neiz.fz.compose.navigation.SetupNavGraphHome
import neiz.fz.compose.view.common.BoxBackground
import neiz.fz.compose.view.common.NavigationBarComponent
import neiz.fz.compose.view.common.TopAppBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    BoxBackground()

    val items = listOf(
        BottomNavigationItem(
            title = "Inicio",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = ScreenHome.Dish.route
        ),
        BottomNavigationItem(
            title = "Encuentranos",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = ScreenHome.Search.route
        ),
        BottomNavigationItem(
            title = "Configuración",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = ScreenHome.Setting.route
        )
    )

    val navController: NavHostController = rememberNavController()

    Scaffold (
        modifier = Modifier.fillMaxSize()
        , topBar = {
            TopAppBarComponent(
                text = "Guacamole MXN",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        },
        bottomBar = {
            NavigationBarComponent(
                items = items,
                onNavigationItem = { item->
                    navController.navigate(item.route){

                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        } // Regresa a la primer pantalla

                        launchSingleTop = true // Abre una sola instancia de cada pantalla

                        restoreState = true
                    }
                }
            )
        }
    ) {paddingValues ->
        SetupNavGraphHome(paddingValues, navController)
    }
}

