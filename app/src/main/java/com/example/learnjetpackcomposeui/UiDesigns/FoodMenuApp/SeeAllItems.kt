package com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.FoodData.allItemList
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.PopularItemModel
import com.example.learnjetpackcomposeui.ui.theme.*

@Composable
fun SeeAllItems(navController: NavController, name: String) {



    Column(
        modifier = Modifier
            .background(color = white)
            .fillMaxSize()
    ) {

        Spacer(
            modifier = Modifier
                .padding(top = 20.dp)
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Arrow",
                    tint = black,
                    modifier = Modifier.size(25.dp)
                )
            }


            Text(
                text = name,
                color = black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Divider(
            modifier = Modifier
                .height(2.dp), color = greyColor
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .weight(1f)
        ) {
            items(allItemList.size) { index ->
                AllItemCard(item = allItemList[index])
            }

        }
    }
}


@Composable
fun AllItemCard(item: PopularItemModel) {

    Card(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = lightGreyColor),
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(item.img),
                contentDescription = "itemImage",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(150.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Text(
                    text = item.title,
                    color = black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(item.ratingImg),
                        contentDescription = "rating",
                        tint = orangeColor,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = item.rating,
                        color = orangeColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }

        }
    }
}
