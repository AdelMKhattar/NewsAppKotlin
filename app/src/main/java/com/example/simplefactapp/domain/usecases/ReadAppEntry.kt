package com.example.simplefactapp.domain.usecases

import com.example.simplefactapp.domain.manager.UserLocalManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private  val localManager: UserLocalManager) {
     operator fun invoke(): Flow<Boolean>{
        return localManager.readAppEntry()
    }
}