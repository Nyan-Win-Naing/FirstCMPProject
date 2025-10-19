package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.GenreVO

class GenreListTypeConverter {
    @TypeConverter
    fun fromGenreList(genreList: List<GenreVO>?): String? {
        return genreList?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toGenreList(jsonString: String?): List<GenreVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}