package com.guilherme.databaseprojectmedium.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.guilherme.databaseprojectmedium.data.AppDatabase.Migration2_3

@Database(
    entities = [Airport::class],
    version = 3,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = Migration2_3::class)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao

    @RenameColumn("airport", fromColumnName = "city", toColumnName = "country")
    class Migration2_3: AutoMigrationSpec

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "airport_database"
                )
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}