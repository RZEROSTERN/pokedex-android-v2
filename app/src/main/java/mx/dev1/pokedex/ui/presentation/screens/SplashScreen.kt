package mx.dev1.pokedex.ui.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import mx.dev1.pokedex.R
import mx.dev1.pokedex.ui.presentation.composables.DrawerScreens
import mx.dev1.pokedex.ui.theme.Red500

@Composable
fun SplashScreen(navController: NavController?) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController?.navigate(DrawerScreens.PokemonSearch.route)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(Red500)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_poke_ball_icon),
            contentDescription = "Pokemon",
            modifier = Modifier.scale(scale.value))
    }
}

@Preview
@Composable
fun SplashScreen_Preview() {
    SplashScreen(null)
}
