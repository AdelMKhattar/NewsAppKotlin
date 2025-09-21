package com.example.simplefactapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplefactapp.domain.usecases.ReadSavaAppEntryUseCases
import com.example.simplefactapp.domain.usecases.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: ReadSavaAppEntryUseCases
) : ViewModel() {
    fun onEvent(event: OnBoardingEvent) {

        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }

    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }

}
