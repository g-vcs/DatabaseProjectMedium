package com.guilherme.databaseprojectmedium.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.guilherme.databaseprojectmedium.data.AppDatabase.Migration2_3

@Database(
    entities = [Airport::class],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = Migration2_3::class),
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao

    @RenameColumn("airport", fromColumnName = "city", toColumnName = "country")
    class Migration2_3: AutoMigrationSpec

    companion object {
        val MIGRATION3_4 = object : Migration(3,4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE airport ADD COLUMN createdAt INTEGER NOT NULL DEFAULT 0")
            }
        }

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "airport_database"
                )
                    .addMigrations(MIGRATION3_4)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}