package mx.dev1.pokedex.ui.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.dev1.pokedex.R
import mx.dev1.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonItem() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.wrapContentSize().padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_poke_ball_icon),
            modifier = Modifier.size(64.dp),
            alignment = TopCenter,
            contentDescription = "Pokemon"
        )

        Text(
            text = "Pikachu",
            modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonItem_Preview() {
    PokedexTheme {
        PokemonItem()
    }
}