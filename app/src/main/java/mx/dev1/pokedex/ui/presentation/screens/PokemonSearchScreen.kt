package mx.dev1.pokedex.ui.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.dev1.pokedex.ui.presentation.composables.DrawerScreens
import mx.dev1.pokedex.ui.presentation.composables.PokemonItem
import mx.dev1.pokedex.ui.presentation.composables.TopBar
import mx.dev1.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonSearchScreen() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp)
    ) {
        items(10) {
            PokemonItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonSearchScreen_Preview() {
    PokedexTheme {
        PokemonSearchScreen()
    }
}