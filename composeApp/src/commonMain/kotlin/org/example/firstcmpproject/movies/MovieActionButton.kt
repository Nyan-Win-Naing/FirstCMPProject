package org.example.firstcmpproject.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_XLARGE
import org.example.firstcmpproject.core.MARGIN_XXLARGE
import org.example.firstcmpproject.core.TEXT_REGULAR_3X

@Composable
fun MovieActionButton(
    modifier: Modifier,
    backgroundColor: Color,
    iconVector: ImageVector?,
    iconPainter: Painter?,
    label: String,
    contentColor: Color,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(backgroundColor, RoundedCornerShape(MARGIN_MEDIUM))
            .height(MARGIN_XXLARGE)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MARGIN_CARD_MEDIUM_2)
        ) {
            if(iconVector != null) {
                Icon(
                    iconVector,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(MARGIN_XLARGE)
                )
            } else if(iconPainter != null) {
                Icon(
                    iconPainter,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(MARGIN_XLARGE)
                )
            }


            Text(
                label,
                color = contentColor,
                fontSize = TEXT_REGULAR_3X,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}