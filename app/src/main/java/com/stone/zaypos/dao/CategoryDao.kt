package com.stone.zaypos.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stone.zaypos.entity.ItemCategory


@Dao
interface CategoryDao {
    @Query("select * from ItemCategory")
    fun getAllItem(): LiveData<List<ItemCategory>>

    @Insert
    fun addNewItem(item: ItemCategory)

    @Update
    fun updateItem(item: ItemCategory)

    @Delete
    fun deleteItem(item: ItemCategory)
}