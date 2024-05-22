package com.example.thenewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.thenewsapp.models.Article
@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticalDatabase : RoomDatabase(){

    abstract fun getArticalDao():ArticalDao
    companion object {
        @Volatile
        private var instance: ArticalDatabase? = null
        private val Lock = Any()
        
        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: createDatabase(context).also{
                instance = it
            }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticalDatabase::class.java,
                "article_db.db"
            ).build()

    }
}
