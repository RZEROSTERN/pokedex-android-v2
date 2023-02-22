package mx.dev1.pokedex.ui.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import mx.dev1.pokedex.ui.presentation.composables.TopBar
import mx.dev1.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonSearchScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Pokemon search")
    }
}
