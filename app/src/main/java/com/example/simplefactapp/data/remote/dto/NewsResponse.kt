package com.example.simplefactapp.data.remote.dto

import com.example.simplefactapp.domain.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)