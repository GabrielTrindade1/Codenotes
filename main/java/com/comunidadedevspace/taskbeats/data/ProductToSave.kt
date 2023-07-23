package com.comunidadedevspace.taskbeats.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductToSave(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val productName: String,
    val productId: Long,
    val quantity: Long
)