package org.example.firstcmpproject.core.persistence

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.persistence.daos.MovieDao
import org.example.firstcmpproject.movies.persistence.type_converter.BelongsToCollectionTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converter.GenreIdsTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converter.GenreListTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converter.OriginalCountryTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converter.ProductionCompanyTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converter.ProductionCountryTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converter.SpokenLanguageTypeConverter

@Database(
    entities = [
        MovieVO::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    BelongsToCollectionTypeConverter::class,
    GenreListTypeConverter::class,
    GenreIdsTypeConverter::class,
    OriginalCountryTypeConverter::class,
    ProductionCompanyTypeConverter::class,
    ProductionCountryTypeConverter::class,
    SpokenLanguageTypeConverter::class,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor: RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}