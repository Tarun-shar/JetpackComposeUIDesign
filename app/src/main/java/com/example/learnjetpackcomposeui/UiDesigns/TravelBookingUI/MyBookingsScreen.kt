package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.bookingsCategory
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.placeCategories
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.placesList
import com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.model.PlacesModel
import com.example.learnjetpackcomposeui.ui.theme.black
import com.example.learnjetpackcomposeui.ui.theme.greenColor
import com.example.learnjetpackcomposeui.ui.theme.greyColor
import com.example.learnjetpackcomposeui.ui.theme.lighBlack
import com.example.learnjetpackcomposeui.ui.theme.lightOrangeColor
import com.example.learnjetpackcomposeui.ui.theme.white

@Composable
@Preview(showBackground = true)
fun MyBookingScreen() {

    var selectedCategory by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = "My Bookings", fontSize = 18.sp, fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(

            )
            {
                itemsIndexed(bookingsCategory) { index, item ->

                    val isSelected = selectedCategory == index
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                if (isSelected) lightOrangeColor else Color.LightGray.copy(alpha = 0.3f)
                            )
                            .clickable {
                                selectedCategory = index
                            }
                            .padding(horizontal = 20.dp, vertical = 8.dp))
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

            LazyColumn(
            ) {
                itemsIndexed(placesList) { index, item ->
                    MyBookingsCard(item)
                }
            }

        }

    }
}

@Composable
fun MyBookingsCard(item: PlacesModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp   // 👈 elevation here
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = white)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "place image",
                modifier = Modifier
                    .height(140.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop,
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f) // important so it takes remaining width
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFE3F2FD),
                                Color.White
                                // soft sky blue
                            )
                        )
                    )
            )
            {
                Column(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        top = 8.dp,
                        end = 8.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Text(
                            text = "${item.name}, ${item.country}",
                            fontWeight = FontWeight.Bold,
                            color = lighBlack,
                            fontSize = 13.sp
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(24.dp)
                                .width(70.dp)
                                .background(
                                    color = Color.Green.copy(alpha = 0.15f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Text(
                                text = "Confirmed",
                                fontSize = 10.sp,
                                color = greenColor,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = item.planDuration, fontSize = 10.sp, color = greyColor)

                }

                Spacer(modifier = Modifier.height(10.dp))

                Divider(
                    modifier = Modifier.height(1.dp), color = greyColor
                )

                Column(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        top = 10.dp,
                        bottom = 8.dp,
                        end = 8.dp
                    )
                ) {
                    Row() {
                        Text(text = "Flight", fontSize = 10.sp, color = greyColor)

                        Spacer(modifier = Modifier.weight(1f))

                        Text(text = "MI 205", fontSize = 10.sp, color = lighBlack)
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row() {
                        Text(text = "Hotel", fontSize = 10.sp, color = greyColor)

                        Spacer(modifier = Modifier.weight(1f))

                        Text(text = "Taj Hotel", fontSize = 10.sp, color = lighBlack)
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .background(
                                greyColor,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .align(Alignment.End)
                            .padding(horizontal = 22.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "View Details",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = white
                        )
                    }

                }
            }

        }
    }

    Spacer(modifier = Modifier.height(15.dp))
}