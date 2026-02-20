package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.placesList
import com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.model.PlacesModel
import com.example.learnjetpackcomposeui.ui.theme.black
import com.example.learnjetpackcomposeui.ui.theme.darkBlueColor
import com.example.learnjetpackcomposeui.ui.theme.greyColor
import com.example.learnjetpackcomposeui.ui.theme.lighBlack
import com.example.learnjetpackcomposeui.ui.theme.lightGreyColor
import com.example.learnjetpackcomposeui.ui.theme.orangeColor
import com.example.learnjetpackcomposeui.ui.theme.skyBlueColor
import com.example.learnjetpackcomposeui.ui.theme.white

@Composable
fun DestinationDetailScreen(navController: NavHostController) {
    val items = listOf("Beach", "Culture", "Nature")


    Column {

        Box {

            // 1️⃣ Image FIRST (background)
            Image(
                painter = painterResource(id = R.drawable.maldives),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )

            // 2️⃣ Row AFTER (drawn on top of image)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                // Back Arrow
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                Color.Black.copy(alpha = 0.4f),
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }

                Text(
                    text = "Destination Detail",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                // Favorite Icon
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                Color.Black.copy(alpha = 0.4f),
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-20).dp)
                .verticalScroll(rememberScrollState()) // ✅ THIS MAKES IT SCROLLABLE
                .background(
                    color = white,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(start = 15.dp, end = 15.dp, top = 20.dp)
        )
        {
            Row()
            {
                Text(
                    text = "New Delhi, India",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))


                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))   // 👈 round corners
                        .background(lightGreyColor)
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(
                        painter = painterResource(R.drawable.baseline_star_24),
                        contentDescription = "rating",
                        tint = orangeColor,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "4.5 (2.4k reviews)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = greyColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))



            Row(verticalAlignment = Alignment.CenterVertically) {
                items.forEachIndexed { index, text ->

                    Text(
                        text = text,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    if (index != items.lastIndex) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Dot()
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Divider(modifier = Modifier.height(1.dp), color = lightGreyColor, thickness = 1.dp)
            Spacer(modifier = Modifier.height(13.dp))
            LazyRow() {
                itemsIndexed(placesList) { index, item ->
                    ShowCard(item)
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "About",
                fontSize = 20.sp,
                color = lighBlack,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(13.dp))

            Text(
                text = stringResource(id = R.string.about),
                fontSize = 14.sp,
                color = lighBlack
            )

            Spacer(modifier = Modifier.height(13.dp))

            Divider(modifier = Modifier.height(1.dp), color = lightGreyColor, thickness = 1.dp)

            Spacer(modifier = Modifier.height(13.dp))

            Row() {
                Column() {
                    Text(text = "Price", fontSize = 18.sp, color = black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(7.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(text = "$", color = orangeColor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "1200",color = black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = " /Person", color = lighBlack, fontSize = 13.sp)
                    }
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(text = "5 Days / 4 Nights", fontSize = 14.sp, color = black)

                }

                Spacer(modifier = Modifier.weight(1f))


                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))   // 👈 round corners
                        .background(lightGreyColor)
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = skyBlueColor, // Sky Blue
                        modifier = Modifier.size(16.dp)
                    )

                    Text(text = " Map",fontSize = 16.sp, color = skyBlueColor)


                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkBlueColor
                ),
                shape = RoundedCornerShape(13.dp)
            ) {
                Text(
                    text = "Book Now",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ShowCard(item: PlacesModel) {

    Card(
        modifier = Modifier
            .size(width = 120.dp, height = 80.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE5E5E5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(5.dp) // 👈 white padding around image
        ) {

            Image(
                painter = painterResource(id = item.image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)) // slightly smaller radius
            )
        }
    }

    Spacer(modifier = Modifier.width(12.dp))
}

@Composable
fun Dot() {
    Box(
        modifier = Modifier
            .size(4.dp)
            .background(
                color = Color.Gray,
                shape = CircleShape
            )
    )
}