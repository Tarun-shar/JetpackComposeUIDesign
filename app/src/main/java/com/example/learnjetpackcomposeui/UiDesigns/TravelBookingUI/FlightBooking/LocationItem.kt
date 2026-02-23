package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.FlightBooking

import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LocationItem(
    title: String,
    city: String,
    code: String,
    underlineColor: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
//            .fillMaxWidth()
    ) {

        Text(title, color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(4.dp))

        Row {
            Text(city, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(6.dp))
            Text(code, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(6.dp))

        val animatedWidth by animateDpAsState(
            targetValue = 80.dp,
            label = ""
        )

        Box(
            modifier = Modifier
                .height(3.dp)
                .width(animatedWidth)
                .background(underlineColor, RoundedCornerShape(50))
        )
    }
}