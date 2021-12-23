package com.stone.zaypos.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemCategory(
    @PrimaryKey(autoGenerate = true)
    var categoryId: Int,
    var categoryName: String

) {
}