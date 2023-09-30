package com.cleo.shop.data.room

import android.content.Context
import androidx.room.Room

class DBBuilder {
    fun initializeDB(context:Context): AppDatabase{
        val builder = Room.databaseBuilder(context, AppDatabase::class.java, "cartDB").fallbackToDestructiveMigration()
        return builder.build()
    }
}