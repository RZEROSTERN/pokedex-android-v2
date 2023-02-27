package mx.dev1.pokedex.ui.presentation.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopBar(title: String = "", buttonIcon: ImageVector,
           onButtonClicked: () -> Unit, onButtonSearchClicked: () -> Unit) {

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
            IconButton(onClick = { onButtonSearchClicked() }) {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search", tint = Color.White)
            }
        }
    )
}
