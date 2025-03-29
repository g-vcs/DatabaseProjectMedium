package com.guilherme.databaseprojectmedium

import android.app.Application
import com.guilherme.databaseprojectmedium.data.AppDatabase

class DatabaseApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getDatabase(this)
    }
}