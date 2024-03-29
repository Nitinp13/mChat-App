package com.example.messmeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.messmeapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

@OptIn(ExperimentalTextApi::class)
val ManRope = Typography(
    bodyMedium = TextStyle(
        fontFamily = FontFamily( Font(
            R.font.manrope_font, variationSettings = FontVariation.Settings(
                FontVariation.weight(600), FontVariation.width(30f), FontVariation.slant(-6f)))
        ),
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily( Font(
            R.font.manrope_font, variationSettings = FontVariation.Settings(
                FontVariation.weight(500), FontVariation.width(30f), FontVariation.slant(-6f)))
        ),
    )


)