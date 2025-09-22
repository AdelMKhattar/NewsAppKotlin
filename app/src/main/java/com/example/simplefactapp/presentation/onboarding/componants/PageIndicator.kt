package com.example.simplefactapp.presentation.onboarding.componants

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.simplefactapp.presentation.Dimensions.IndicatorSize
import com.example.simplefactapp.ui.theme.BlueGray


@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    numberOfPages: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color= BlueGray
) {
    Row(modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(numberOfPages) { page ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(
                        color = if (page == selectedPage)  selectedColor else  unSelectedColor

                    )
            )
        }
    }
}