package org.example.firstcmpproject.movies.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.firstcmpproject.core.DETAILS_BUTTON_ICON_SIZE
import org.example.firstcmpproject.core.MARGIN_40
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_LARGE
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_SMALL
import org.example.firstcmpproject.core.MARGIN_XLARGE
import org.example.firstcmpproject.core.MOVIE_ITEM_HEIGHT
import org.example.firstcmpproject.core.TEXT_LARGE
import org.example.firstcmpproject.core.TEXT_REGULAR
import org.example.firstcmpproject.core.TEXT_REGULAR_2X
import org.example.firstcmpproject.core.TEXT_REGULAR_3X
import org.example.firstcmpproject.core.TEXT_SMALL
import org.example.firstcmpproject.core.TEXT_SMALL_2X
import org.example.firstcmpproject.movies.MovieItem
import org.example.firstcmpproject.movies.detail.state.MovieDetailsState
import org.example.firstcmpproject.movies.detail.viewmodel.MovieDetailsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailsRoute(
    viewModel: MovieDetailsViewModel,
    onTapBack: () -> Unit,
    onTapMovie: (Long) -> Unit,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    MovieDetailsScreen(
        state = state,
        onTapBack = onTapBack,
        onTapMovie = onTapMovie,
    )
}

@Composable
fun MovieDetailsScreen(
    state: MovieDetailsState,
    onTapBack: () -> Unit,
    onTapMovie: (Long) -> Unit
) {
    Scaffold(containerColor = Color.Black) {

        if (state.movieDetails != null) {
            LazyColumn() {
                // Movie Image

                item {
                    DetailsMovieImage(movie = state.movieDetails, onTapBack = onTapBack)
                }


                // Spacer
                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM_2))
                }

                // LOGO
                item {
                    DetailsMovieLogo()
                }

                // Spacer
                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }

                // Movie Title
                item {
                    Text(
                        state.movieDetails.title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = TEXT_LARGE,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }

                // Detail Info
                item {
                    MovieDetailsInfo(movie = state.movieDetails)
                }

                // Spacer
                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }

                // Play and Download buttons
                item {
                    MovieDetailsButtons()
                }

                // Spacer
                item {
                    Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
                }

                item {
                    Text(
                        state.movieDetails.overview,
                        color = Color.White,
                        fontSize = TEXT_REGULAR,
                        maxLines = 3,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
                }

                // Cast
                item {
                    Text(
                        "Cast: Taron Egerton, Sofia Carson, Jason Bateman ... more",
                        color = Color.DarkGray,
                        fontSize = TEXT_SMALL,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                // Director
                item {
                    Text(
                        "Director: Jaume Collet-Serra",
                        color = Color.DarkGray,
                        fontSize = TEXT_SMALL,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM_2))
                }

//            Details Action Button
                item {

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(MARGIN_40),
                        modifier = Modifier.padding(horizontal = MARGIN_40)
                    ) {
                        MovieDetailActionButton(Icons.Default.Add, "My List", modifier = Modifier)
                        MovieDetailActionButton(Icons.Default.ThumbUp, "Rate", modifier = Modifier)
                        MovieDetailActionButton(Icons.Default.Share, "Share", modifier = Modifier)
                    }

                }

//            Spacer
                item {
                    Spacer(modifier = Modifier.height(MARGIN_LARGE))
                }

                // More Like This
                item {
                    Text(
                        "More Like This",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TEXT_REGULAR_3X,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }

//            Movie Vertical Grid
                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
                        verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
                        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
                        modifier = Modifier.height((MOVIE_ITEM_HEIGHT + MARGIN_CARD_MEDIUM_2) * ((state.similarMovies.count() / 3) + 1))
                    ) {
                        items(state.similarMovies) {
                            MovieItem(movie = it, onTapMovie = onTapMovie)
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun MovieDetailActionButton(icon: ImageVector, title: String, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            MARGIN_SMALL
        ),
        modifier = modifier
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(
                DETAILS_BUTTON_ICON_SIZE
            )
        )
        Text(title, color = Color.White)
    }
}

//@Composable
//@Preview
//fun MovieDetailsScreenPreview() {
//    MovieDetailsScreen(onTapBack = {}, onTapMovie = {})
//}