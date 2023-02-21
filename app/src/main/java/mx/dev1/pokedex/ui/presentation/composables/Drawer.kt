package mx.dev1.pokedex.ui.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.dev1.pokedex.R
import mx.dev1.pokedex.ui.theme.PokedexTheme

sealed class DrawerScreens(val title: String, val route: String) {
    object Splash : DrawerScreens("Splash", "splash_screen")
    object PokemonSearch : DrawerScreens("Pokemon", "main_screen")
}

private val screens = listOf(
    DrawerScreens.Splash,
    DrawerScreens.PokemonSearch
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_poke_ball_icon),
            modifier = Modifier.size(24.dp),
            contentDescription = "App icon"
        )

        screens.forEach { screen ->
            if(screen.route != "splash_screen") {
                Spacer(Modifier.height(24.dp))
                Text(
                    text = screen.title,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.clickable {
                        onDestinationClicked(screen.route)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    PokedexTheme {
        Drawer{}
    }
}