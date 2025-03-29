package com.guilherme.databaseprojectmedium.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guilherme.databaseprojectmedium.DatabaseApplication
import com.guilherme.databaseprojectmedium.data.Airport
import kotlinx.coroutines.launch

class AirportViewModel : ViewModel() {
    private val airportDao = DatabaseApplication.database.airportDao()

    fun insertAirport(name: String, iataCode: String, passengers: Int) {
        val airport = Airport(name = name, iataCode = iataCode, passenger = passengers)
        viewModelScope.launch {
            airportDao.insertAirport(airport)
        }
    }
}