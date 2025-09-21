package com.example.simplefactapp.domain.usecases

import com.example.simplefactapp.domain.manager.UserLocalManager

class SaveAppEntry(
    private val userLocalManager: UserLocalManager
) {
    suspend  operator fun invoke(){
        userLocalManager.saveAppEntry()
    }
}