package org.example.firstcmpproject.movies.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.download
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.movies.MovieActionButton
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieDetailsButtons() {
    Column(
        verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        modifier = Modifier.fillMaxWidth().padding(horizontal = MARGIN_MEDIUM_2)
    ) {
        MovieActionButton(
            backgroundColor = Color.White,
            iconVector = Icons.Default.PlayArrow,
            iconPainter = null,
            label = "Play",
            contentColor = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        MovieActionButton(
            backgroundColor = Color.Gray,
            iconVector = null,
            iconPainter = painterResource(Res.drawable.download),
            label = "Download",
            contentColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}