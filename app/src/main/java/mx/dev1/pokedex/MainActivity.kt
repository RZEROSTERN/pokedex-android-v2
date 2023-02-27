package mx.dev1.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import mx.dev1.pokedex.ui.presentation.composables.Navigation
import mx.dev1.pokedex.ui.presentation.screens.AppMainScreen
import mx.dev1.pokedex.ui.theme.PokedexTheme
import mx.dev1.pokedex.ui.theme.Red500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                AppMainScreen(rememberNavController())
            }
        }
    }
}
