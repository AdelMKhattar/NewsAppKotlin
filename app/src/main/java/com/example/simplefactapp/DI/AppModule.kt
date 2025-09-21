package com.example.simplefactapp.DI

import android.app.Application
import com.example.simplefactapp.data.manager.UserLocalManagerImp
import com.example.simplefactapp.domain.manager.UserLocalManager
import com.example.simplefactapp.domain.usecases.ReadAppEntry
import com.example.simplefactapp.domain.usecases.ReadSavaAppEntryUseCases
import com.example.simplefactapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Provide dependency UserLocalManager for the implementation of the UserLocalManager interface
    @Provides
    @Singleton
    fun provideUserLocalManager(
        application: Application
    ): UserLocalManager = UserLocalManagerImp(application)


    //Provide dependency UserLocalManager for the AppEntry usecases
    @Provides
    @Singleton
    fun provideReadSaveAppEntryUsecases(
        localManager: UserLocalManager
    )= ReadSavaAppEntryUseCases(
        readAppEntry = ReadAppEntry(localManager),
        saveAppEntry = SaveAppEntry(localManager)
    )
}