package mx.dev1.pokedex.ui.presentation.composables

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun TopBar(title: String = "", buttonIcon: ImageVector,
           onButtonClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(imageVector = buttonIcon, contentDescription = "Drawer Icon")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search", tint = Color.White)
            }
        }
    )
}
