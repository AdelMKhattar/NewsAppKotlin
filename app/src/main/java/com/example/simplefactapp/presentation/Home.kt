package com.example.simplefactapp.presentation

import androidx.compose.foundation.background
import com.example.simplefactapp.presentation.navgraph.Routes
import com.example.simplefactapp.presentation.onboarding.OnBoardingEvent
import com.example.simplefactapp.presentation.onboarding.pages



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.simplefactapp.presentation.common.NewsButton
import com.example.simplefactapp.presentation.common.TextNewsButton
import com.example.simplefactapp.presentation.onboarding.Dimensions.mediumPadding2
import com.example.simplefactapp.presentation.onboarding.Dimensions.pageIndicatorWidth
import com.example.simplefactapp.presentation.onboarding.componants.OnBoardingPage
import com.example.simplefactapp.presentation.onboarding.componants.PageIndicator
import com.example.simplefactapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

@Composable
fun HomeScreen(

) {

    Box(
        modifier = Modifier
            .fillMaxSize().background(Color.White),// Fill the whole screen
        contentAlignment = Alignment.Center // Center content both vertically and horizontally
    ) {
        Text(text = "Hello, World!")       // Your centered text
    }
}