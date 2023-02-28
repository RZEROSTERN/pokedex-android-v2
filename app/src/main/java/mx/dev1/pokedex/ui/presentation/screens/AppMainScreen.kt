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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch
import mx.dev1.pokedex.R
import mx.dev1.pokedex.ui.presentation.composables.DrawerScreens
import mx.dev1.pokedex.ui.presentation.composables.SearchBar
import mx.dev1.pokedex.ui.presentation.composables.TopBar
import mx.dev1.pokedex.ui.presentation.helpers.SearchWidgetState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppMainScreen(
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showTopBar = false

    var searchWidgetState by remember{ mutableStateOf(SearchWidgetState.CLOSED) }
    var searchTextState by remember { mutableStateOf("") }

    navBackStackEntry?.destination?.route?.let {
        showTopBar = it != "splash_screen"
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if(showTopBar) {
                if(searchWidgetState == SearchWidgetState.OPENED) {
                    SearchBar(onCloseSearch = {
                        coroutineScope.launch {
                            if (searchTextState.isNotEmpty() || searchTextState.isNotBlank()) {
                                searchTextState = ""
                            } else {
                                searchWidgetState = SearchWidgetState.CLOSED
                            }
                        }
                    })
                } else {
                    TopBar(
                        title = "Pokedex",
                        buttonIcon = Icons.Filled.Menu,
                        onButtonClicked = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        },
                        onButtonSearchClicked = {
                            coroutineScope.launch {
                                searchWidgetState = SearchWidgetState.OPENED
                            }
                        },
                    )
                }
            }
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
                composable(DrawerScreens.PokemonSearch.route) { PokemonSearchScreen(navController = navController) }
                composable(DrawerScreens.SinglePokemon.route) { SinglePokemonScreen() }
            }
        }
    }
}
