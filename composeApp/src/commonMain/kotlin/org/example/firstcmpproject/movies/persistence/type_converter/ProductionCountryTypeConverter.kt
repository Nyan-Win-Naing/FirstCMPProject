package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.ProductionCompanyVO
import org.example.firstcmpproject.movies.data.vos.ProductionCountryVO

class ProductionCountryTypeConverter {

    @TypeConverter
    fun fromProductionCountries(productionCountries: List<ProductionCountryVO>?): String? {
        return productionCountries?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toProductionCountries(jsonString: String?): List<ProductionCountryVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}