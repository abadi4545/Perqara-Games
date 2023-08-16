package com.example.perqaragames.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.perqaragames.data.local.converters.Converter
import com.example.perqaragames.data.local.database.dao.FavoritesDao
import com.example.perqaragames.domain.model.GameDetails


@TypeConverters(
    Converter::class
)
@Database(
    entities = [
        GameDetails::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){

    abstract fun favoritesDao(): FavoritesDao

}