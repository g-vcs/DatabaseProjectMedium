package com.guilherme.databaseprojectmedium.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val iataCode: String,
    val name: String,
    val passenger: Int,
    @ColumnInfo(defaultValue = "")
    val city: String
)
