package org.example.firstcmpproject.movies.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.firstcmpproject.core.utils.FEATURED_MOVIE_IMAGE_BASE_URL
import org.example.firstcmpproject.core.utils.MOVIE_ITEM_IMAGE_BASE_URL

@Entity(tableName = "movies")
@Serializable
data class MovieVO(
    @SerialName("adult")
    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @SerialName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @SerialName("belongs_to_collection")
    @ColumnInfo(name = "belongs_to_collection")
    val belongsToCollectionVO: BelongsToCollectionVO?,

    @SerialName("budget")
    @ColumnInfo(name = "budget")
    val budget: Long?,

    @SerialName("genres")
    @ColumnInfo(name = "genres")
    val genres: List<GenreVO>?,

    @SerialName("homepage")
    @ColumnInfo(name = "homepage")
    val homePage: String?,

    @SerialName("genre_ids")
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>?,

    @SerialName("imdb_id")
    @ColumnInfo(name = "imdb_id")
    val imdbId: String?,

    @SerialName("origin_country")
    @ColumnInfo(name = "origin_country")
    val originalCountry: List<String>?,

    @SerialName("id")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,

    @SerialName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @SerialName("overview")
    @ColumnInfo(name = "overview")
    val overview: String,

    @SerialName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @SerialName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @SerialName("production_companies")
    @ColumnInfo(name = "production_companies")
    val productionCompanies: List<ProductionCompanyVO>?,

    @SerialName("production_countries")
    @ColumnInfo(name = "production_countries")
    val productionCountries: List<ProductionCountryVO>?,

    @SerialName("revenue")
    @ColumnInfo(name = "revenue")
    val revenue: Long?,

    @SerialName("runtime")
    @ColumnInfo(name = "runtime")
    val runtime: Int?,

    @SerialName("spoken_languages")
    @ColumnInfo(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageVO>?,

    @SerialName("status")
    @ColumnInfo(name = "status")
    val status: String?,

    @SerialName("tagline")
    @ColumnInfo(name = "tagline")
    val tagLine: String?,

    @SerialName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @SerialName("title")
    @ColumnInfo(name = "title")
    val title: String,

    @SerialName("video")
    @ColumnInfo(name = "video")
    val video: Boolean,

    @SerialName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,
) {
    fun getFullMoviePosterPath() : String {
        return "$FEATURED_MOVIE_IMAGE_BASE_URL$posterPath"
    }

    fun getFullMovieBackdropPath() : String {
        return "$MOVIE_ITEM_IMAGE_BASE_URL$backdropPath"
    }

    fun getReleaseYear(): String {
        return  releaseDate.substring(0..3)
    }

    fun getHourMinutes(): String {
        if(runtime != null) {
            val hour = runtime / 60
            val minute = runtime % 60
            return "${hour}h ${minute}m"
        } else {
            return ""
        }
    }
}