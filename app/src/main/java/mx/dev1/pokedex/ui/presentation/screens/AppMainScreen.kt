package mx.dev1.pokedex.ui.presentation.screens

import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Surface
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import mx.dev1.pokedex.ui.presentation.composables.Drawer
import mx.dev1.pokedex.ui.presentation.composables.DrawerScreens

@Composable
fun AppMainScreen() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch { drawerState.open() }
        }

        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch { drawerState.close() }
                        navController.navigate(route) {
                            navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = DrawerScreens.Splash.route) {

                composable(DrawerScreens.Splash.route) { SplashScreen(navController = navController) }
                composable(DrawerScreens.PokemonSearch.route) { PokemonSearchScreen(openDrawer = { openDrawer() }) }
            }
        }
    }
}