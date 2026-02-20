package com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.placeCategories
import com.example.learnjetpackcomposeui.UiDesigns.ListsData.placesList
import com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.model.PlacesModel
import com.example.learnjetpackcomposeui.ui.theme.*

@Composable
fun ExploreScreen(navController: NavController) {

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
        )
        {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = "Explore", fontSize = 18.sp, fontWeight = FontWeight.Bold
            )


            // 🔥 This pushes everything before it to the start
            Spacer(modifier = Modifier.weight(1f))

            Box(
                contentAlignment = Alignment.TopEnd
            )
            {
                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = "notification",
                    tint = black,
                    modifier = Modifier.size(30.dp)
                )

                Box(
                    modifier = Modifier
                        .offset(x = 1.dp, y = (-1).dp)
                        .size(16.dp)
                        .background(redColor, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "0",
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
            }


        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Best Destinations",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = "Search Places",
                            color = darkGreyColor
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = darkGreyColor,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),

                    modifier = Modifier
                        .weight(1f)
                        .height(55.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Icon(
                        imageVector = Icons.Default.FilterAlt,
                        contentDescription = "Filter",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            )
            {
                itemsIndexed(placeCategories) { index, item ->

                    val isSelected = selectedCategory == index

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                if (isSelected) lightOrangeColor else Color.LightGray.copy(alpha = 0.3f)
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
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier.background(color = white)
            )
            {
                item {
                    LazyRow() {
                        itemsIndexed(placesList) { index, item ->
                            PlacesCard(navController, item)
                        }

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row() {
                        Text(
                            text = "Top Offers",
                            fontSize = 20.sp,
                            color = black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "View All",
                            fontSize = 14.sp,
                            color = greyColor,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyRow(modifier = Modifier.background(color = white)) {
                        itemsIndexed(placesList) { index, item ->
                            OfferPlacesCard(navController,item)
                        }

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row() {
                        Text(
                            text = "Suggested Offers",
                            fontSize = 20.sp,
                            color = black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "View All",
                            fontSize = 14.sp,
                            color = greyColor,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyRow() {
                        itemsIndexed(placesList) { index, item ->
                            PlacesCard(navController,item)
                        }

                    }
                }
            }


        }
    }
}

@Composable
fun OfferPlacesCard(navController: NavController, item: PlacesModel) {

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(180.dp),
        onClick = {
            navController.navigate("destinationDetailScreen")
        },
        shape = RoundedCornerShape(28.dp)
    )
    {

        Box {
            // Background Image
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "place Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Soft White Overlay (like design)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,              // full image left
                                Color.White.copy(alpha = 0.3f), // slight fade
                                Color.White.copy(alpha = 0.85f) // strong fade right
                            ),
                            startX = 0f,
                            endX = Float.POSITIVE_INFINITY
                        )
                    )
            )

            // Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            )
            {

                // Top Text Section
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item.name, // Maldives
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = lighBlack
                    )

                    Text(
                        text = item.planDuration, // 5 Days - 4 Nights
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }

                // Bottom Section
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .align(Alignment.End),
                        color = greyColor,
                        thickness = 1.dp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.Bottom
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "${item.price}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = lighBlack
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = "/Person",
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .padding(horizontal = 22.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = "Book Now",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = lighBlack
                        )
                    }
                }
            }
        }
    }

    Spacer(modifier = Modifier.width(15.dp))

}

@Composable
fun PlacesCard(navController: NavController, item: PlacesModel) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(250.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            navController.navigate("destinationDetailScreen")
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box {

            // Image
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Bottom Overlay
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            )
                        )
                    )
                    .padding(12.dp)
            ) {

                Text(
                    text = item.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = item.country,
                    color = Color.LightGray,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = item.ratingImg),
                        contentDescription = "ratingImage",
                        tint = orangeColor,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = item.rating.toString(),
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.width(15.dp))
}