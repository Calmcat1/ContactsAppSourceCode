package com.example.uidesign2.NewsModel


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String?,
    val urlToImage: String?
)