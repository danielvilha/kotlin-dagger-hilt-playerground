package com.danielvilha.hilt_playerground.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danielvilha.hilt_playerground.datasource.cache.model.BlogCacheEntity

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@Database(entities = [BlogCacheEntity::class], version = 1, exportSchema = false)
abstract class BlogDatabase: RoomDatabase() {
    abstract fun blogDao(): BlogDao

    companion object {
        val DATABASE_NAME: String = "blog_db"
    }
}