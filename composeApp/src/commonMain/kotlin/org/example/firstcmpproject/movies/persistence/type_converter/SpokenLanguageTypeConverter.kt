package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.ProductionCompanyVO
import org.example.firstcmpproject.movies.data.vos.SpokenLanguageVO

class SpokenLanguageTypeConverter {
    @TypeConverter
    fun fromSpokenLanguages(spokenLanguages: List<SpokenLanguageVO>?): String? {
        return spokenLanguages?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toSpokenLanguages(jsonString: String?): List<SpokenLanguageVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}