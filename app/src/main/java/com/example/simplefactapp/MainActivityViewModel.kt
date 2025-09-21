package com.example.simplefactapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplefactapp.domain.usecases.ReadSavaAppEntryUseCases
import com.example.simplefactapp.presentation.navgraph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val appEntryUseCases: ReadSavaAppEntryUseCases) :
    ViewModel() {
    var splashScreenCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Routes.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHome ->

            if (shouldStartFromHome) {
                startDestination = Routes.NewsNavigation.route
            } else {
                startDestination = Routes.AppStartNavigation.route
            }
            delay(300)

            splashScreenCondition = false
        }.launchIn(viewModelScope)
    }


}