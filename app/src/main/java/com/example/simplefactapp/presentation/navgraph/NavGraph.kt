package com.example.simplefactapp.presentation.navgraph

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems

import com.example.simplefactapp.presentation.home.HomeScreen
import com.example.simplefactapp.presentation.home.HomeViewModel
import com.example.simplefactapp.presentation.onboarding.OnBoardingScreen
import com.example.simplefactapp.presentation.onboarding.OnBoardingViewModel


@Composable
fun NavGraph(startDestination: String) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        //Nested navigation graph for onboarding and related screens
            navigation(
                route = Routes.AppStartNavigation.route,
                startDestination = Routes.OnBoardingScreen.route
            ) {

                composable(route = Routes.OnBoardingScreen.route) {
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(event = viewModel::onEvent)

                }
            }
        navigation(
            route = Routes.NewsNavigation.route,
            startDestination = Routes.NewsNavigationScreen.route
        ) {
            composable(route = Routes.NewsNavigationScreen.route) {
                val viewModel: HomeViewModel=hiltViewModel()
                val articles=viewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles,{})

            }
        }


    }
}

