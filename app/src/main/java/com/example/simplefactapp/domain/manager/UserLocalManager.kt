package com.example.simplefactapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface UserLocalManager {
     suspend fun  saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

}