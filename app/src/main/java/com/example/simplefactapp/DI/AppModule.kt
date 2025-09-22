package com.example.simplefactapp.DI

import android.app.Application
import com.example.simplefactapp.data.manager.UserLocalManagerImp
import com.example.simplefactapp.data.remote.api.NewsApi
import com.example.simplefactapp.data.repository.NewsRepositoryImp
import com.example.simplefactapp.domain.manager.UserLocalManager
import com.example.simplefactapp.domain.repositories.NewsRepository
import com.example.simplefactapp.domain.usecases.ReadAppEntry
import com.example.simplefactapp.domain.usecases.ReadSavaAppEntryUseCases
import com.example.simplefactapp.domain.usecases.SaveAppEntry
import com.example.simplefactapp.domain.usecases.news.GetNews
import com.example.simplefactapp.domain.usecases.news.NewsUsecases
import com.example.simplefactapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository{
        return NewsRepositoryImp(api = newsApi)
    }
    @Provides
    @Singleton
    fun provideNewsUsecases(newsRepository: NewsRepository): NewsUsecases{
        return NewsUsecases(
            getNews = GetNews(newsRepository)
        )
    }
}