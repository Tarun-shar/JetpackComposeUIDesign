package com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.FoodData.cartItemList
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.PopularItemModel
import com.example.learnjetpackcomposeui.ui.theme.black
import com.example.learnjetpackcomposeui.ui.theme.darkBlueColor
import com.example.learnjetpackcomposeui.ui.theme.greyColor
import com.example.learnjetpackcomposeui.ui.theme.lightGreyColor
import com.example.learnjetpackcomposeui.ui.theme.white

@Composable
fun CheckoutScreen(navController: NavHostController) {
    Column(

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 25.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {

            // Back Arrow
            IconButton(onClick = {
                navController.popBackStack()
            }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = black,
                    modifier = Modifier
                        .size(38.dp)
                        .background(
                            lightGreyColor,
                            shape = CircleShape
                        )
                        .padding(8.dp)
                )
            }

            Text(
                text = "Cart",
                fontSize = 20.sp,
                color = black,
                fontWeight = FontWeight.Bold
            )

            // Favorite Icon
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Favorite",
                tint = black,
                modifier = Modifier
                    .size(38.dp)
                    .background(
                        lightGreyColor,
                        shape = CircleShape
                    )
                    .padding(8.dp)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = greyColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {

            itemsIndexed(cartItemList) { index, item ->
                CartCard(item = item)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = lightGreyColor
        )


        Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp)) {
            Text(text = "Total", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Rs. 1250", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = lightGreyColor
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
//                navController.navigate("foodDetailScreen")
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
                text = "Checkout",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun CartCard(item: PopularItemModel) {

    Card(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = white),
    ) {
        Row(modifier = Modifier.padding(10.dp))
        {
            Image(
                painter = painterResource(item.img),
                contentDescription = "itemImage",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(120.dp)

            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.padding(vertical = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = item.title,
                        color = black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = item.rating,
                        color = black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Spacer(modifier = Modifier.width(6.dp))


                }

                Spacer(modifier = Modifier.height(10.dp))

                QuantitySelector1()
            }

        }
    }
}

@Composable
fun QuantitySelector1() {

    var quantity by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .height(32.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // 🔹 Minus Button
        IconButton(
            onClick = {
                if (quantity > 1) quantity--
            },
            modifier = Modifier.size(28.dp) // smaller button
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "Decrease",
                tint = black,
                modifier = Modifier.size(16.dp) // smaller icon
            )
        }

        // 🔹 Quantity Text
        Text(
            text = quantity.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 6.dp)
        )

        // 🔹 Plus Button
        IconButton(
            onClick = { quantity++ },
            modifier = Modifier.size(28.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Increase",
                tint = black,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
