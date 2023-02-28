package mx.dev1.pokedex.ui.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.dev1.pokedex.ui.theme.PokedexTheme

@Composable
fun SinglePokemonScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Single pokemon")
    }
}

@Preview(showBackground = true)
@Composable
fun SinglePokemonScreen_Preview() {
    PokedexTheme {
        SinglePokemonScreen()
    }
}