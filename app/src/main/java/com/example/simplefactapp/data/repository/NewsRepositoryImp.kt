package com.example.simplefactapp.data.repository

import androidx.compose.ui.res.painterResource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSourceFactory
import com.example.simplefactapp.data.remote.NewsPagingSource
import com.example.simplefactapp.data.remote.api.NewsApi
import com.example.simplefactapp.domain.models.Article
import com.example.simplefactapp.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow


class NewsRepositoryImp(private val api: NewsApi) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                NewsPagingSource(api, sources.joinToString(separator = ","))
            },
        ).flow
    }


}