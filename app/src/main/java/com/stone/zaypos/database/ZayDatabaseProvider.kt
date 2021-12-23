package com.stone.zaypos.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object ZayDatabaseProvider {
    private var database:ZayDatabase?=null
    fun instance(context: Context):ZayDatabase{
        if (database==null){
            database= Room.databaseBuilder(context,ZayDatabase::class.java,"Zay_db").build()
        }
        return database!!
    }
}