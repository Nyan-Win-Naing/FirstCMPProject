package org.example.firstcmpproject.core

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.netflix_sans
import firstcmpproject.composeapp.generated.resources.netflix_sans_bold
import firstcmpproject.composeapp.generated.resources.netflix_sans_medium
import org.jetbrains.compose.resources.Font

@Composable
fun NetflixSensFontFamily() = FontFamily(
    Font(Res.font.netflix_sans, FontWeight.Normal),
    Font(Res.font.netflix_sans_medium, FontWeight.Medium),
    Font(Res.font.netflix_sans_bold, FontWeight.Bold),
)

@Composable
fun NetflixSansTypography() = Typography().run {
    val fontFamily = NetflixSensFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}