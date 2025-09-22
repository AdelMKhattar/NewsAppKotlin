package com.example.simplefactapp.presentation.common

import android.view.Display

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.simplefactapp.R
import com.example.simplefactapp.domain.models.Article
import com.example.simplefactapp.domain.models.Source
import com.example.simplefactapp.presentation.Dimensions.ExtraSmallPadding2
import com.example.simplefactapp.presentation.Dimensions.SmallIconSize
import com.example.simplefactapp.presentation.Dimensions.articleSize
import com.example.simplefactapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (() -> Unit)? = null
) {
    Row(Modifier.clickable { onClick }) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(article.urlToImage).build(),
            contentDescription = null,
            modifier = Modifier
                .size(articleSize)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop

        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(articleSize)
        ) {
            Text(
                article.title,
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(
                    id = R.color.text_title
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,


            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),
                    fontSize = 9.sp
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.body),
                    fontSize = 9.sp
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                author = "Adel",
                content = "this is content",
                description = "",
                publishedAt = "2 hours",
                source = Source("", "BBC"),
                "Hello news hello again here adellet's take a look on what we have hereeeee rasfdaera dfa sdf aer afa",
                url = "",
                ""
            ),

            ) {

        }
    }
}