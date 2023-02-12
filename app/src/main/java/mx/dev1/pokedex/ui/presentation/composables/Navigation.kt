package mx.dev1.pokedex.ui.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.dev1.pokedex.ui.presentation.screens.PokemonSearchScreen
import mx.dev1.pokedex.ui.presentation.screens.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen") {

        composable("splash_screen") { SplashScreen(navController = navController) }
        composable("main_screen") { PokemonSearchScreen(navController = navController) }
    }
}