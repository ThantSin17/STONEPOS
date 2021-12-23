package com.stone.zaypos.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Item")
data class ZayItem(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var itemName:String,
    var sellType:String,
    var image:String,
    var price:Int,
    var inStock:Int,
    var categoryId:Int

) {
}