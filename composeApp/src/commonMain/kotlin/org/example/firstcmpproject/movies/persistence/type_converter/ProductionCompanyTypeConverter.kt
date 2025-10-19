package org.example.firstcmpproject.movies.persistence.type_converter

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.ProductionCompanyVO

class ProductionCompanyTypeConverter {

    @TypeConverter
    fun fromProductionCompanies(productionCompanies: List<ProductionCompanyVO>?): String? {
        return productionCompanies?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toProductionCompanies(jsonString: String?): List<ProductionCompanyVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}