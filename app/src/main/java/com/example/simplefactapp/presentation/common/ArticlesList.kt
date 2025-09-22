package com.example.simplefactapp.presentation.common

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.simplefactapp.domain.models.Article
import com.example.simplefactapp.presentation.Dimensions.ExtraSmallPadding
import com.example.simplefactapp.presentation.Dimensions.mediumPadding1


@Composable
fun ArticleList(
    modifier: Modifier= Modifier,
    articles: LazyPagingItems<Article>,
    onClick:(Article)-> Unit
){
    val handlePageResult=handlePagingResult(articles)

    Log.d("handle",handlePageResult.toString())
    Log.d("ARTICLES","${articles.itemCount.toString()},${articles.loadState}")
    if (handlePageResult){
        Log.d("1","im here")
        LazyColumn (
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(mediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding)
        ){
            items(count=articles.itemCount){
                articles[it]?.let{article->
                    ArticleCard(article = article,onClick={onClick(article )})
                }
            }
        }
    }


}

@Composable
fun handlePagingResult(articles: LazyPagingItems<Article>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(mediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(modifier = Modifier.padding(horizontal = mediumPadding1))
        }
    }

}