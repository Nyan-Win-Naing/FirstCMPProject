package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser

class OriginalCountryTypeConverter {

    @TypeConverter
    fun fromOriginalCountry(originalCountry: List<String>?): String? {
        return originalCountry?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toOriginalCountry(jsonString: String?): List<String>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}