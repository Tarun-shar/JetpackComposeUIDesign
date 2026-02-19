package com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.ui.theme.*


@Composable
fun StartScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(white),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)

        )
        {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .width(200.dp)
                    .height(130.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Android",
                color = darkBlueColor,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 30.dp)) {
            Button(
                onClick = {
                    navController.navigate("login"){
                        popUpTo("start") { inclusive = true }
                    }
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
                    text = "Get Started",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Don't have an account",
                color = darkBlueColor,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                        navController.navigate("Signup"){
                            popUpTo("start") { inclusive = true }
                        }
                    }, textAlign = TextAlign.Center
            )
        }
    }
}
