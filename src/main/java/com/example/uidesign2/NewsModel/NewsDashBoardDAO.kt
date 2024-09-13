package com.example.uidesign2.NewsModel
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM article_table")
    suspend fun getAllNews(): List<NewsEntity>

    @Insert
    suspend fun insertAll(news: List<NewsEntity>)
}