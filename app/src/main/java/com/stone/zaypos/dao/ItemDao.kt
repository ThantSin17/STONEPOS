package com.stone.zaypos.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stone.zaypos.entity.ZayItem

@Dao
interface ItemDao {
    @Query("select * from Item")
    fun getAllItem():LiveData<List<ZayItem>>

    @Insert
    fun addNewItem(item:ZayItem)

    @Update
    fun updateItem(item: ZayItem)

    @Delete
    fun deleteItem(item:ZayItem)
}