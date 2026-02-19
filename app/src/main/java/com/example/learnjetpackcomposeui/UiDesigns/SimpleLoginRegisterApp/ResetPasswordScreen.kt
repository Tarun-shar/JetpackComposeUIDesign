package com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.ui.theme.darkBlueColor
import com.example.learnjetpackcomposeui.ui.theme.greyColor

@Composable

fun ResetPasswordScreen(navController : NavHostController) {

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.outline_arrow_back_24),
            contentDescription = "Back Arrow",
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .width(24.dp)
                .height(24.dp),

            )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().weight(1f)
        )
        {
            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "Reset Password",
                fontSize = 32.sp,
                color = darkBlueColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Enter your email to reset your password", fontSize = 16.sp, color = darkBlueColor
            )
            Spacer(Modifier.height(50.dp))
            // --- Email ---
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Email", fontSize = 14.sp) },
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = null)
                },
                singleLine = true,
                textStyle = TextStyle(
                    color = darkBlueColor,   // 👈 text color
                    fontSize = 14.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            )


            Spacer(Modifier.height(50.dp))

            Button(
                onClick = {
                    navController.navigate("VerifyCodeScreen")
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
                    text = "Reset Password",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

        }

        Divider(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .height(1.dp),
            color = greyColor

        )


        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 60.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Remember your password? ",
                fontSize = 12.sp,
                color = darkBlueColor,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Login",
                fontSize = 12.sp,
                color = darkBlueColor,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable{
                    navController.navigate("login"){
                        popUpTo("ResetPasswordScreen") { inclusive = true }

                    }
                }

            )
        }

    }
}