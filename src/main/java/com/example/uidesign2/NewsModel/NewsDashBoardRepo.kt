package com.example.uidesign2.NewsModel


class NewsRepository(private val newsDao: NewsDao) {

    suspend fun getAllNews(): List<NewsEntity> {
        return newsDao.getAllNews()
    }

    suspend fun saveNews(news: List<NewsEntity>) {
        newsDao.insertAll(news)
    }
}