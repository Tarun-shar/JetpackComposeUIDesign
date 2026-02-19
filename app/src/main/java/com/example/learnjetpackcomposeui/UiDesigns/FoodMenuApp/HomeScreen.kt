package com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp

import android.net.Uri
import android.widget.Scroller
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.PopularItemModel
import com.example.learnjetpackcomposeui.ui.theme.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TextButton
import androidx.navigation.NavController
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.FoodData.popularItemList
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.FoodData.suggestedItemList
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.SuggestedItemModel


@Composable
fun HomeScreen(navController: NavController) {

    val categories = listOf(
        "All", "Pizza", "Burger", "Drinks", "Dessert", "Chinese"
    )


    var selectedCategory by remember { mutableStateOf(0) }

    var searchText by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 25.dp)
            .fillMaxSize()
    )
    {
        Row(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "Deliver to", fontSize = 14.sp
            )

            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location",
                tint = orangeColor,
                modifier = Modifier.padding(horizontal = 5.dp)
            )

            Text(
                text = "Noida, India", fontSize = 14.sp, fontWeight = FontWeight.Bold
            )


            // 🔥 This pushes everything before it to the start
            Spacer(modifier = Modifier.weight(1f))

            // ✅ Profile Icon
            Icon(
                imageVector = Icons.Default.PersonPin,
                contentDescription = "Profile",
                tint = greyColor,
                modifier = Modifier.size(35.dp)
            )
        }

        Divider(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .height(1.dp), color = greyColor
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        {
            // Custom Search
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                    .padding(horizontal = 12.dp), contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(modifier = Modifier.fillMaxWidth()) {

                        BasicTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            singleLine = true,
                            textStyle = TextStyle(fontSize = 14.sp),
                            modifier = Modifier.fillMaxWidth()
                        )

                        if (searchText.isEmpty()) {
                            Text(
                                text = "Search", color = Color.Gray, fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .height(1.dp), color = greyColor
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        {
            itemsIndexed(categories) { index, item ->

                val isSelected = selectedCategory == index

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (isSelected) orangeColor else Color.LightGray.copy(alpha = 0.3f)
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

        Spacer(modifier = Modifier.height(15.dp))

        Divider(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .height(1.dp), color = greyColor
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
        )
        {

            item {
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = "Popular Items",
                        color = black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    TextButton(
                        onClick = {
                            val title = Uri.encode("Popular Items")
                            navController.navigate("viewAllScreen/$title")
                        }
                    ) {
                        Text(
                            text = "View All",
                            fontSize = 14.sp,
                            color = greyColor
                        )
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    itemsIndexed(popularItemList) { index, item ->
                        PopularItemCard(navController,item)
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Divider(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .height(1.dp), color = greyColor
                )

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = "Recommended Items",
                        color = black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    TextButton(
                        onClick = {
                            val title = Uri.encode("Recommended Items")
                            navController.navigate("viewAllScreen/$title")

                        }
                    ) {
                        Text(
                            text = "View All",
                            fontSize = 14.sp,
                            color = greyColor
                        )
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    itemsIndexed(popularItemList) { index, item ->
                        PopularItemCard(navController, item)
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Divider(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .height(1.dp), color = greyColor
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Suggested Items", color = black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {

                Box(
                    modifier = Modifier
                        .height(250.dp)
                        .padding(horizontal = 15.dp)
                ) {

                    LazyColumn {
                        items(suggestedItemList) { item ->
                            SuggestedItemCard(navController,item)
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(15.dp))

                Divider(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .height(1.dp), color = greyColor
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = "Recently Viewed Items",
                        color = black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    TextButton(
                        onClick = {
                            val title = Uri.encode("Recently Viewed Items")
                            navController.navigate("viewAllScreen/$title")

                        }
                    ) {
                        Text(
                            text = "View All",
                            fontSize = 14.sp,
                            color = greyColor
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    itemsIndexed(popularItemList) { index, item ->
                        PopularItemCard(navController, item)
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))
            }

        }


    }


}


@Composable
fun PopularItemCard(navController: NavController, item: PopularItemModel) {

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = white),
        modifier = Modifier.clickable  {
            val route = "foodDetailScreen/${item.id}"
            navController.navigate(route)
        }
    ) {
        Column(
        ) {

            Image(
                painter = painterResource(item.img),
                contentDescription = "itemImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.title,
                fontSize = 10.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 6.dp)
            ) {

                Icon(
                    painter = painterResource(item.ratingImg),
                    contentDescription = "rating",
                    tint = orangeColor,
                    modifier = Modifier.size(14.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = item.rating,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    Spacer(modifier = Modifier.width(10.dp))
}

@Composable
fun SuggestedItemCard(navController: NavController, item: SuggestedItemModel) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 15.dp)
            .clickable  {
                val route = "foodDetailScreen/${item.id}"
                navController.navigate(route)
            },
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = white),
    ) {
        Column(
        ) {

            Image(
                painter = painterResource(item.img),
                contentDescription = "itemImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp)),

                )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.title,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 6.dp)
            ) {

                Icon(
                    painter = painterResource(item.ratingImg),
                    contentDescription = "rating",
                    tint = orangeColor,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = item.rating,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
}

