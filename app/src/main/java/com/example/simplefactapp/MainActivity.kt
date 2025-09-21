package com.example.simplefactapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.simplefactapp.domain.usecases.ReadSavaAppEntryUseCases

import com.example.simplefactapp.presentation.navgraph.NavGraph
import com.example.simplefactapp.presentation.navgraph.Routes
import com.example.simplefactapp.presentation.onboarding.OnBoardingEvent
import com.example.simplefactapp.presentation.onboarding.OnBoardingScreen
import com.example.simplefactapp.presentation.onboarding.OnBoardingViewModel
import com.example.simplefactapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Allow content to draw behind status and navigation bars for edge-to-edge experience
        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().apply {
            Log.d("testt", viewModel.splashScreenCondition.toString())
            setKeepOnScreenCondition(condition = { viewModel.splashScreenCondition })
        }


        enableEdgeToEdge()
        setContent {
            Log.d("Main Route", viewModel.startDestination)

            NewsAppTheme {
                NavGraph(viewModel.startDestination)


            }

        }
    }

}


