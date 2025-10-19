package org.example.firstcmpproject.movies.home.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.cast
import firstcmpproject.composeapp.generated.resources.download
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_XLARGE
import org.example.firstcmpproject.core.TEXT_LARGE
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),
        title = {
            Text(
                "For Shade",
                fontSize = TEXT_LARGE,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            Icon(
                painterResource(Res.drawable.cast),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(MARGIN_XLARGE)
            )
            Spacer(modifier = Modifier.width(MARGIN_CARD_MEDIUM_2))
            Icon(
                painterResource(Res.drawable.download),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(MARGIN_XLARGE)
            )
            Spacer(modifier = Modifier.width(MARGIN_CARD_MEDIUM_2))
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(MARGIN_XLARGE)
            )
        }
    )
}