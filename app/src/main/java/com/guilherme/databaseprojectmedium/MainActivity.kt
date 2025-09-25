package com.guilherme.databaseprojectmedium

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.guilherme.databaseprojectmedium.data.Airport
import com.guilherme.databaseprojectmedium.ui.theme.DatabaseProjectMediumTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val airportDao by lazy { DatabaseApplication.database.airportDao() }

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DatabaseProjectMediumTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Button(
                        onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                airportDao.insertAirport(
                                    Airport(
                                        name = "airport",
                                        iataCode = "iataCode1",
                                        passenger = 250,
                                        city = "Porto"
                                    )
                                )
                            }
                        }
                    ) {
                        Text(text = "Add an Airport to DB")
                    }
                }
            }
        }
    }
}
