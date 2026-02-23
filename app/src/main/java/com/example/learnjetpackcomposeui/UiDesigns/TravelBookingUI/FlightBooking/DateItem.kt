package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.FlightBooking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DateItem(
    title: String,
    date: String,
    underlineColor: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
//            .fillMaxWidth()
    ) {

        Text(title, color = Color.Gray)

        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(date, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.DateRange, contentDescription = null)
        }

        Spacer(modifier = Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .height(3.dp)
                .width(100.dp)
                .background(underlineColor, RoundedCornerShape(50))
        )
    }
}