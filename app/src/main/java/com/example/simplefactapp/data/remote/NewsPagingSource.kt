package com.example.simplefactapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.simplefactapp.data.remote.api.NewsApi
import com.example.simplefactapp.domain.models.Article

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String

) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }

    // Keeps track of the total number of articles we've loaded so far
    private var totalNewsCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(page, sources, "32dc56d4fa5944f182827f051013efbf ")
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }//remove duplicated articles
            LoadResult.Page(
                articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null

            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

}