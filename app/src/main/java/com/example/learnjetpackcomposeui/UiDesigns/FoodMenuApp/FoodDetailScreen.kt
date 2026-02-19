package com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.PopularItemModel
import com.example.learnjetpackcomposeui.ui.theme.*

@Composable
//@Preview(showBackground = true)
fun FoodDetailScreen(navController: NavController, itemId: Int?) {
    Column(
        modifier = Modifier
            .background(color = white)
            .fillMaxSize()
    ) {
        val selectedItem = FoodData.popularItemList.find { it.id == itemId }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .statusBarsPadding() // remove this if added
        ) {

            // 🔹 Background Image
            Image(
                painter = painterResource(id = selectedItem?.img ?: R.drawable.photo1jpg),
//                painter = painterResource(id =  com.example.learnjetpackcomposeui.R.drawable.photo1jpg),
                contentDescription = "Item Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            // 🔹 Top Overlay Row (Overlapping Layer)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
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
                        tint = Color.White,
                        modifier = Modifier
                            .size(30.dp)
                            .background(
                                Color.Black.copy(alpha = 0.4f),
                                shape = CircleShape
                            )
                            .padding(6.dp)
                    )
                }


                // Favorite Icon
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            Color.Black.copy(alpha = 0.4f),
                            shape = CircleShape
                        )
                        .padding(6.dp)
                )
            }


        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.padding(horizontal = 20.dp).weight(1f)
        )
        {
            Text(
                text = selectedItem!!.title,
                fontSize = 24.sp,
                color = black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row() {
                Icon(
                    painter = painterResource(id = selectedItem.ratingImg),
                    contentDescription = "ratingImage",
                    modifier = Modifier.size(20.dp),
                    tint = orangeColor
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = selectedItem.rating,
                    fontSize = 18.sp,
                    color = black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "(120 reviews)",
                    fontSize = 18.sp,
                    color = greyColor,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "A delicious and juicy burger made with fresh ingredients, crispy lettuce, melted cheese, and perfectly grilled patty. Served hot and packed with flavor.",
                fontSize = 18.sp,
                color = greyColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            Divider(
                modifier = Modifier.height(1.dp),
                color = greyColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Rs. 1250",
                fontSize = 22.sp,
                color = black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            QuantitySelector()


        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("foodDetailScreen")
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
                text = "Add to Cart",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun QuantitySelector() {

    var quantity by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                .padding(horizontal = 16.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {

            // 🔹 Minus Button
            IconButton(
                onClick = {
                    if (quantity > 1) {
                        quantity--
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Decrease",
                    tint = black
                )
            }

            // 🔹 Quantity Text
            Text(
                text = quantity.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            // 🔹 Plus Button
            IconButton(
                onClick = {
                    quantity++
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Increase",
                    tint = black
                )
            }
        }
    }

}
