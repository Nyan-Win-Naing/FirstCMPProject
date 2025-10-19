package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.BelongsToCollectionVO

class BelongsToCollectionTypeConverter {
    @TypeConverter
    fun fromBelongsToCollection(belongsToCollection: BelongsToCollectionVO?): String? {
        return belongsToCollection?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toBelongsToCollection(jsonString: String?): BelongsToCollectionVO? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }

}