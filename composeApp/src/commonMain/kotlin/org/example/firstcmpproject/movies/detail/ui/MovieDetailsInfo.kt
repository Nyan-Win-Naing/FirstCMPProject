package org.example.firstcmpproject.movies.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.ad
import firstcmpproject.composeapp.generated.resources.dolby_vision
import firstcmpproject.composeapp.generated.resources.message
import firstcmpproject.composeapp.generated.resources.spatial_audio
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_SMALL
import org.example.firstcmpproject.core.MARGIN_XLARGE
import org.example.firstcmpproject.core.MARGIN_XXLARGE
import org.example.firstcmpproject.core.TEXT_REGULAR_2X
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieDetailsInfo(movie: MovieVO) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MARGIN_CARD_MEDIUM_2),
        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM)
    ) {
        Text(movie.getReleaseYear(), color = Color.White, fontSize = TEXT_REGULAR_2X)
        Box(
            modifier = Modifier.clip(
                RoundedCornerShape(
                    MARGIN_SMALL
                )
            ).background(Color.Gray)
                .padding(horizontal = MARGIN_SMALL, vertical = MARGIN_SMALL)
        ) {
            Text("16+", color = Color.White)
        }

        Text(movie.getHourMinutes(), color = Color.White, fontSize = TEXT_REGULAR_2X)
        Icon(
            painterResource(Res.drawable.dolby_vision),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(MARGIN_XXLARGE)
        )
        Box(
            modifier = Modifier.clip(RoundedCornerShape(MARGIN_SMALL))
                .border(width = 2.dp, color = Color.Gray)
                .padding(horizontal = MARGIN_MEDIUM, vertical = MARGIN_SMALL)
        ) {
            Text("HD", fontSize = TEXT_REGULAR_2X, color = Color.White)
        }
        Icon(
            painterResource(Res.drawable.spatial_audio),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(MARGIN_XLARGE)
        )
        Icon(
            painterResource(Res.drawable.ad),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(MARGIN_XLARGE)
        )
        Icon(
            painterResource(Res.drawable.message),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(MARGIN_XLARGE)
        )
    }
}