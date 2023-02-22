package mx.dev1.pokedex.ui.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import mx.dev1.pokedex.R
import mx.dev1.pokedex.ui.presentation.composables.DrawerScreens
import mx.dev1.pokedex.ui.presentation.composables.TopBar
import mx.dev1.pokedex.ui.theme.PokedexTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppMainScreen(
    navController: NavHostController?
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                title = "Pokedex",
                buttonIcon = Icons.Filled.Menu,
                onButtonClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .size(126.dp)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        modifier = Modifier
                            .matchParentSize(),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                    )

                    Image(
                        modifier = Modifier
                            .scale(1.4f),
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    ) {
        navController?.apply {
            NavHost(
                navController = this,
                startDestination = DrawerScreens.Splash.route) {

                composable(DrawerScreens.Splash.route) { SplashScreen(navController = navController) }
                composable(DrawerScreens.PokemonSearch.route) { PokemonSearchScreen() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppMainScreen_Preview() {
    PokedexTheme {
        AppMainScreen(navController = null)
    }
}