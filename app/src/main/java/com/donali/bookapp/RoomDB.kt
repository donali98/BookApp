package com.donali.bookapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.donali.bookapp.daos.BookDao
import com.donali.bookapp.entities.Book

@Database(entities = [Book::class],version = 1,exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun bookDao():BookDao


    companion object{
        @Volatile
        private var INSTANCE:RoomDB? = null

        fun getInstance(appContext:Context):RoomDB{
            val temp = INSTANCE
            if(temp != null) return temp
            synchronized(this){
                val instance  = Room.databaseBuilder(appContext,RoomDB::class.java,"Library").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}