package com.comunidadedevspace.taskbeats.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: ProductToSave)

    @Query("Select * from product")
    fun getAll(): List<ProductToSave>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(product: Task)

    //Deletando todos
    @Query("DELETE from product")
    fun deleteAll()

    //Deletando pelo id
    @Delete
    fun deleteById(ProductToSave: ProductToSave)

}