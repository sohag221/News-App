package com.example.thenewsapp.repository

import com.example.thenewsapp.api.RetrofitInstance
import com.example.thenewsapp.db.ArticalDatabase
import com.example.thenewsapp.models.Article

class NewsRepository(val db:ArticalDatabase) {

    suspend fun getHeadlines(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) =db.getArticalDao().upsert(article)

    fun getFavouriteNews() =db.getArticalDao().getAllArticals()

    suspend fun deleteArtical(article: Article) =db.getArticalDao().deleteArtical(article)


}