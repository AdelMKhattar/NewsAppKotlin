package com.example.simplefactapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.simplefactapp.R
import com.example.simplefactapp.domain.models.Article
import com.example.simplefactapp.presentation.Dimensions.mediumPadding1
import com.example.simplefactapp.presentation.common.ArticleList
import com.example.simplefactapp.presentation.common.SearchBar
import com.example.simplefactapp.presentation.navgraph.Routes

@Composable
fun HomeScreen(articles: LazyPagingItems<Article>, navigate: (String) -> Unit) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5") {
                        it?.title ?: ""
                    }
            } else {
                ""
            }
        }
    }
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = mediumPadding1)
            .statusBarsPadding().background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = mediumPadding1)
        )

        Spacer(modifier = Modifier.height(mediumPadding1))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = mediumPadding1)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigate(Routes.SearchScreen.route)
            }
        )

        Spacer(modifier = Modifier.height(mediumPadding1))

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(start = mediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(R.color.placeholder),
            text = titles
        )
//
//
//        Text(
//
////              titles, modifier = Modifier
////                .fillMaxWidth()
////                .padding(start = mediumPadding1)
////                .basicMarquee(), fontSize = 12.sp,
////            color = colorResource(id = R.color.placeholder)
//        )

        Spacer(modifier = Modifier.height(mediumPadding1))

        ArticleList(
            modifier = Modifier.padding(horizontal = 1.7.dp),
            articles = articles,
            onClick = {
                //TODO: Navigate to Details Screen
            }
        )
    }
}

