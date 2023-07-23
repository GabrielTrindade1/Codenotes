package com.comunidadedevspace.taskbeats

import android.app.Application
import androidx.room.Room
import com.comunidadedevspace.taskbeats.data.AppDataBase

class Codenotes : Application() {

    private lateinit var dataBase: AppDataBase

    override fun onCreate() {
        super.onCreate()

        instance = this

        dataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "taskbeats-database"
        ).build()
    }

    fun getAppDataBase(): AppDataBase {
        return dataBase
    }

    companion object {
        private var instance: Codenotes? = null
        fun getInstance() = instance!!
    }
}