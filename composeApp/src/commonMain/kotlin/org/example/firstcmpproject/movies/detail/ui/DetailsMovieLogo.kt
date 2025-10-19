package org.example.firstcmpproject.movies.detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.netflix_n_logo
import org.example.firstcmpproject.core.MARGIN_LARGE
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.jetbrains.compose.resources.painterResource

@Composable
fun DetailsMovieLogo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
    ) {
        Image(
            painterResource(Res.drawable.netflix_n_logo),
            contentDescription = null,
            modifier = Modifier.size(
                MARGIN_LARGE
            )
        )
        Text(
            "FILM",
            color = Color.White,
            fontWeight = FontWeight.Medium,
            letterSpacing = 6.sp,
        )
    }
}