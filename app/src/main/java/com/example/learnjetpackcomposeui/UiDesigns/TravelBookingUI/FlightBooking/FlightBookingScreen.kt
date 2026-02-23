package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.FlightBooking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightBookingScreen() {

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    var showCitySheet by remember { mutableStateOf(false) }
    var selectingFrom by remember { mutableStateOf(true) }

    var fromCity by remember { mutableStateOf("New York") }
    var fromCode by remember { mutableStateOf("NYC") }

    var toCity by remember { mutableStateOf("Bali") }
    var toCode by remember { mutableStateOf("DPS") }

    var departureDate by remember { mutableStateOf("June 15, 2024") }
    var returnDate by remember { mutableStateOf("June 20, 2024") }

    var showDatePicker by remember { mutableStateOf(false) }
    var selectingDeparture by remember { mutableStateOf(true) }

    val cityList = listOf(
        "New York - NYC",
        "Bali - DPS",
        "London - LHR",
        "Dubai - DXB",
        "Delhi - DEL"
    )

    Box {

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // FROM & TO ROW
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                LocationItem(
                    title = "From",
                    city = fromCity,
                    code = fromCode,
                    underlineColor = Color(0xFF4A90E2)
                ) {
                    selectingFrom = true
                    showCitySheet = true
                }

                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        // 🔄 Swap animation
                        val tempCity = fromCity
                        val tempCode = fromCode
                        fromCity = toCity
                        fromCode = toCode
                        toCity = tempCity
                        toCode = tempCode
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.SwapHoriz,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }

                LocationItem(
                    title = "To",
                    city = toCity,
                    code = toCode,
                    underlineColor = Color(0xFFE67E22)
                ) {
                    selectingFrom = false
                    showCitySheet = true
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider()
            Spacer(modifier = Modifier.height(20.dp))

            // DATE ROW
            Row(modifier = Modifier.fillMaxWidth()) {

                DateItem(
                    title = "Departure",
                    date = departureDate,
                    underlineColor = Color(0xFF4A90E2)
                ) {
                    selectingDeparture = true
                    showDatePicker = true
                }

                Spacer( modifier = Modifier.weight(1f))

                DateItem(
                    title = "Return",
                    date = returnDate,
                    underlineColor = Color(0xFFE67E22)
                ) {
                    selectingDeparture = false
                    showDatePicker = true
                }
            }
        }

        // ✈ Bottom Sheet City Selector
        if (showCitySheet) {
            ModalBottomSheet(
                onDismissRequest = { showCitySheet = false },
                sheetState = sheetState
            ) {
                cityList.forEach { city ->
                    Text(
                        text = city,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val parts = city.split(" - ")
                                if (selectingFrom) {
                                    fromCity = parts[0]
                                    fromCode = parts[1]
                                } else {
                                    toCity = parts[0]
                                    toCode = parts[1]
                                }
                                showCitySheet = false
                            }
                            .padding(16.dp),
                        fontSize = 18.sp
                    )
                }
            }
        }

        // 📅 Date Picker Dialog
        if (showDatePicker) {
            val datePickerState = rememberDatePickerState()

            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val millis = datePickerState.selectedDateMillis
                            if (millis != null) {
                                val formatted =
                                    SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                                        .format(Date(millis))

                                if (selectingDeparture)
                                    departureDate = formatted
                                else
                                    returnDate = formatted
                            }
                            showDatePicker = false
                        }
                    ) {
                        Text("OK")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}