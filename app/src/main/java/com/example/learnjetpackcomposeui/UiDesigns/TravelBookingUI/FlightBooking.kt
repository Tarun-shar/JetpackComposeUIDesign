package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.bookingsCategory
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.travelCategory
import com.example.learnjetpackcomposeui.ui.theme.black
import com.example.learnjetpackcomposeui.ui.theme.lighBlack
import com.example.learnjetpackcomposeui.ui.theme.lightOrangeColor
import com.example.learnjetpackcomposeui.ui.theme.skyBlueColor
import com.example.learnjetpackcomposeui.ui.theme.white

@Composable
@Preview(showSystemUi = true)
fun FlightBooking() {
    var selectedCategory by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 18.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                // Back Arrow
                IconButton(onClick = {
//                navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = lighBlack,
                        modifier = Modifier
                            .size(38.dp)
                            .background(
                                Color.LightGray,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }

                Text(
                    text = "Booking",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                // Favorite Icon
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.SupportAgent,
                        contentDescription = "support",
                        tint = lighBlack,
                        modifier = Modifier
                            .size(38.dp)
                            .background(
                                Color.LightGray,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            )
            {
                itemsIndexed(travelCategory) { index, item ->

                    val isSelected = selectedCategory == index
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                if (isSelected) skyBlueColor else Color.LightGray.copy(alpha = 0.3f)
                            )
                            .clickable {
                                selectedCategory = index
                            }
                            .padding(horizontal = 20.dp, vertical = 10.dp))
                    {
                        Text(
                            text = item,
                            color = if (isSelected) Color.White else Color.Black,
                            fontSize = 14.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row() {
                Text(text = "Select Your Flight", fontSize = 18.sp, color = black, fontWeight = FontWeight.Bold)
            }
        }

    }
}