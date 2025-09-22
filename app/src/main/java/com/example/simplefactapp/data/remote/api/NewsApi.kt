package com.example.simplefactapp.data.remote.api

import com.example.simplefactapp.data.remote.dto.NewsResponse
import com.example.simplefactapp.domain.models.Source
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page")page : Int,
        @Query("sources")sources: String,
        @Query("apiKey")apiKey: String
    ): NewsResponse
}