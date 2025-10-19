package org.example.firstcmpproject.movies.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.TEXT_LARGE
import org.example.firstcmpproject.movies.MovieItem
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.MovieVO

@Composable
fun GenreNameAndMovies(genre: GenreVO, movieList: List<MovieVO>, onTapMovie: (Long) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
        modifier = Modifier.padding(top = MARGIN_MEDIUM_2)
    ) {
        Text(
            genre.name,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_LARGE,
            modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
            contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2)
        ) {
            items(count = movieList.count()) { index ->
                MovieItem(
                    movie = movieList[index],
                    onTapMovie = {
                        onTapMovie(movieList[index].id)
                    },
                )
            }
        }
    }
}