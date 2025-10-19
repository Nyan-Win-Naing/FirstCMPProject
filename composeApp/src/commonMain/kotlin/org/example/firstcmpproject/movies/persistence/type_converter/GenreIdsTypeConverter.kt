package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.GenreVO

class GenreIdsTypeConverter {
    @TypeConverter
    fun fromGenreIds(genreIds: List<Int>?): String? {
        return genreIds?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toGenreIds(jsonString: String?): List<Int>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}