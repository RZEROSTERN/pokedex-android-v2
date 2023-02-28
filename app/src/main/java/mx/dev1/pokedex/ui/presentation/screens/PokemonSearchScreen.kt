package mx.dev1.pokedex.ui.presentation.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.dev1.pokedex.ui.presentation.composables.PokemonItem
import mx.dev1.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonSearchScreen(
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp)
    ) {
        items(150) {
            PokemonItem(navController)
        }
    }
}
