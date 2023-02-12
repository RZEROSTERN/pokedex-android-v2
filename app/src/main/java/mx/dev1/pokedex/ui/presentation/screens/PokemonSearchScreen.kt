package mx.dev1.pokedex.ui.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun PokemonSearchScreen(navController: NavController?) {
    TopAppBar(
        title = { Text(text = "Pokedex") }
    )

    Box(
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun PokemonSearchScreen_Preview() {
    PokemonSearchScreen(null)
}
