package org.example.firstcmpproject.movies.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_LARGE
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_XXLARGE
import org.example.firstcmpproject.core.TEXT_REGULAR_2X

@Composable
fun MovieCategorySection(modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        modifier = modifier
    ) {
        MovieCategory(text = "TV Shows", dropDownShown = false, modifier = Modifier)
        MovieCategory(text = "Movies", dropDownShown = false, modifier = Modifier)
        MovieCategory(text = "Categories", dropDownShown = true, modifier = Modifier)
    }
}

@Composable
fun MovieCategory(text: String, dropDownShown: Boolean, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.height(MARGIN_XXLARGE)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(MARGIN_LARGE)
            )
            .background(Color.Transparent)
            .padding(
                horizontal = MARGIN_MEDIUM_2, vertical = MARGIN_CARD_MEDIUM_2,
            )
    ) {
        Row {
            Text(
                text,
                color = Color.White,
                fontSize = TEXT_REGULAR_2X,
                fontWeight = FontWeight.Bold,
            )

            if (dropDownShown) {
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    }
}
