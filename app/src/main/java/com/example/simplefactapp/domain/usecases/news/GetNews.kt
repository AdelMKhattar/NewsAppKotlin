package com.example.simplefactapp.domain.usecases.news

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.simplefactapp.domain.models.Article
import com.example.simplefactapp.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private  val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(sources)
    }
}