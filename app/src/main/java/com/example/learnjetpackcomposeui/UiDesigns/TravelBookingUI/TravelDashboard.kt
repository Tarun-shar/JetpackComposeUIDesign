package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TravelDashboard(navController: NavController) {

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar() {

                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = {selectedIndex = 0},
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Home") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = {selectedIndex = 1},
                    icon = { Icon(Icons.Default.Search, null) },
                    label = { Text("Search") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 2,
                    onClick = {selectedIndex = 2},
                    icon = { Icon(Icons.Default.LibraryBooks, null) },
                    label = { Text("Bookings") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 3,
                    onClick = {selectedIndex = 3},
                    icon = { Icon(Icons.Default.FavoriteBorder, null) },
                    label = { Text("Favourite") }
                )

                NavigationBarItem(
                    selected = selectedIndex == 4,
                    onClick = {selectedIndex = 4},
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Profile") }
                )
            }
        }
    ) { padding ->

        Box(modifier = Modifier.padding(padding)){

            when(selectedIndex){
                0 -> ExploreScreen(navController)
                1 -> Text("Search Screen")
                2 -> MyBookingScreen()
                3 -> FlightBooking()
                4 -> Text("Profile Screen")
            }
        }
    }
}