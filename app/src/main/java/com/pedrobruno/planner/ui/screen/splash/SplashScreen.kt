package com.pedrobruno.planner.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.pedrobruno.planner.R
import com.pedrobruno.planner.ui.theme.Zinc950
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onNavigateToHome()
    }
    Box(
        modifier = modifier.background(Zinc950),
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo"
        )
    }
}

@Preview(device = Devices.PIXEL_3A, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(Modifier.fillMaxSize(), onNavigateToHome = {})
}