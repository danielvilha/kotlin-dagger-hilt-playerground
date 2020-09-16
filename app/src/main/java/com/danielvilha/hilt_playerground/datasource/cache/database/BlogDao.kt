package com.danielvilha.hilt_playerground.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danielvilha.hilt_playerground.datasource.cache.model.BlogCacheEntity

/**
 * Created by danielvilha on 17/07/20
 * https://github.com/danielvilha
 */
@Dao
interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogEntity: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>
}