package com.example.simplefactapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.simplefactapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf<Page>(
    Page(
        title = "Hello",
        description = "This is the first onboarding screen",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Hello again",
        description = "This is the second onboarding screen",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Hello again",
        description = "This is the third onboarding screen",
        image = R.drawable.onboarding3
    ),
)
