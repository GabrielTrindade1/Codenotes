package com.comunidadedevspace.taskbeats.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class, ProductToSave::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun productDao(): ProductDao
}

