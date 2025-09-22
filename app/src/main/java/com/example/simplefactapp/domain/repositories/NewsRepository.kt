package com.example.simplefactapp.domain.repositories

import androidx.paging.PagingData
import com.example.simplefactapp.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}