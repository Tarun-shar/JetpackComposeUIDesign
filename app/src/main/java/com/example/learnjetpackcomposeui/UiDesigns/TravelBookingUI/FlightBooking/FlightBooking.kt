package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.FlightBooking

import android.graphics.drawable.Icon
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.flightsList
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.travelCategory
import com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.model.FlightModel
import com.example.learnjetpackcomposeui.ui.theme.black
import com.example.learnjetpackcomposeui.ui.theme.darkBlueColor
import com.example.learnjetpackcomposeui.ui.theme.greyColor
import com.example.learnjetpackcomposeui.ui.theme.lighBlack
import com.example.learnjetpackcomposeui.ui.theme.lightGreyColor
import com.example.learnjetpackcomposeui.ui.theme.skyBlueColor

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
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {

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
                                Color.LightGray, shape = CircleShape
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
                                Color.LightGray, shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
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
                            .padding(horizontal = 20.dp, vertical = 8.dp)) {
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
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Select Your Flight",
                    fontSize = 18.sp,
                    color = black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))


                RoundTripSwitch()


            }

            Spacer(modifier = Modifier.height(4.dp))
            FlightBookingScreen()
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Flights", fontSize = 18.sp, color = black, fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn(modifier = Modifier.weight(1f)) {
                itemsIndexed(flightsList) { index, item ->
                    FlightCard(item)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row() {
                Text(
                    text = "Total Price",
                    fontSize = 18.sp,
                    color = black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "$1920", fontSize = 18.sp, color = black, fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = skyBlueColor
                ),
                shape = RoundedCornerShape(13.dp)
            ) {
                Text(
                    text = "Login",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}

@Composable
fun RoundTripSwitch() {

    var isChecked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Round Trip", fontSize = 15.sp, color = greyColor
        )


        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier.scale(0.5f), // 👈 smaller size
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White, checkedTrackColor = skyBlueColor, // Sky Blue
                uncheckedThumbColor = Color.White, uncheckedTrackColor = Color.LightGray
            )
        )
    }
}


@Composable
fun FlightCard(flightsList: FlightModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp   // 👈 soft shadow
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {

            Image(
                painter = painterResource(id = flightsList.img),
                contentDescription = "image",
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

                // Airline + Price
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = flightsList.name,
                        fontSize = 16.sp,
                        color = black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = flightsList.price,
                        color = black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Time Row
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = flightsList.startTime,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(18.dp)
                    )

                    Text(
                        text = flightsList.endTime,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Stop + Select Button
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = flightsList.stop,
                        fontSize = 14.sp,
                        color = greyColor
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Icon(
                        imageVector = Icons.Default.Album,
                        contentDescription = null,
                        tint = greyColor,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = flightsList.endTime,
                        fontSize = 14.sp,
                        color = greyColor
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    SelectExample()
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun SelectExample() {

    var isSelected by remember { mutableStateOf(false) }

    SelectChip(
        isSelected = isSelected, onClick = { isSelected = !isSelected })
}

@Composable
fun SelectChip(
    text: String = "Select", isSelected: Boolean, onClick: () -> Unit
) {

    val backgroundColor by animateColorAsState(
        if (isSelected) Color(0xFFFFEEE5) else Color(0xFFF4F4F4)
    )

    val borderColor by animateColorAsState(
        if (isSelected) Color(0xFFFF7A2F) else Color.Transparent
    )

    val textColor by animateColorAsState(
        if (isSelected) Color(0xFFFF7A2F) else Color.Gray
    )

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(
                width = 1.5.dp, color = borderColor, shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 22.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center) {
        Text(
            text = text, color = textColor, fontWeight = FontWeight.SemiBold
        )
    }
}
