package com.pedrobruno.planner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pedrobruno.planner.ui.navigation.Home
import com.pedrobruno.planner.ui.navigation.Splash
import com.pedrobruno.planner.ui.screen.home.HomeScreen
import com.pedrobruno.planner.ui.screen.home.HomeUiState
import com.pedrobruno.planner.ui.screen.home.HomeViewModel
import com.pedrobruno.planner.ui.screen.splash.SplashScreen
import com.pedrobruno.planner.ui.theme.PlannerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PlannerTheme {
                val navController = rememberNavController()
                val homeViewModel: HomeViewModel = hiltViewModel()
                val homeUiState = homeViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }

                    composable<Home> {
                        HomeScreen(
                            modifier = Modifier.fillMaxSize(),
                            state = homeUiState.value,
                            onEvent = homeViewModel::onEvent
                        )
                    }
                }
            }
        }
    }
}

