package com.guilherme.databaseprojectmedium.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface AirportDao {
    @Insert
    suspend fun insertAirport(airport: Airport)

    @Update
    suspend fun updateAirport(airport: Airport)

    @Delete
    suspend fun deleteAirport(airport: Airport)
}
