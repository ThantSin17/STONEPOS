package com.stone.zaypos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stone.zaypos.dao.CategoryDao
import com.stone.zaypos.dao.ItemDao
import com.stone.zaypos.entity.ItemCategory
import com.stone.zaypos.entity.ZayItem

@Database(entities = [ItemCategory::class, ZayItem::class],version = 1)
abstract class ZayDatabase : RoomDatabase() {
    abstract fun ItemDao():ItemDao
    abstract fun CategoryDao():CategoryDao
}