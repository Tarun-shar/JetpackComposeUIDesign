package com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.ui.theme.darkBlueColor
import com.example.learnjetpackcomposeui.ui.theme.greyColor

@Composable
fun VerifyCodeScreen(navController: NavController) {

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
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Verify Code", fontSize = 32.sp, color = darkBlueColor
            )

            Spacer(Modifier.height(20.dp))
            Text(
                text = "Enter the 4-digits code sent to your email",
                fontSize = 16.sp,
                color = darkBlueColor
            )

            Spacer(Modifier.height(40.dp))

            OtpScreen()

            Spacer(Modifier.height(40.dp))

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
                    text = "Verify",
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(Modifier.height(20.dp))
            Text(
                text = "Resend Code (00:30)", fontSize = 16.sp, color = greyColor
            )
            Spacer(Modifier.height(20.dp))
            Divider(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .height(1.dp)
                    .width(100.dp),
                color = greyColor
            )

            Spacer(Modifier.height(15.dp))
            Text(
                text = "Change Email", fontSize = 16.sp, color = darkBlueColor
            )
        }
    }
}

@Composable
fun OtpScreen() {

    val focusRequesters = List(4) { FocusRequester() }
    val otpValues = remember { mutableStateListOf("", "", "", "") }

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        repeat(4) { index ->

            OutlinedTextField(
                value = otpValues[index],
                onValueChange = { value ->
                    if (value.length <= 1 && value.all { it.isDigit() }) {
                        otpValues[index] = value

                        if (value.isNotEmpty() && index < 3) {
                            focusRequesters[index + 1].requestFocus()
                        }
                    }
                },
                modifier = Modifier
                    .width(70.dp)
                    .padding(horizontal = 10.dp)
                    .focusRequester(focusRequesters[index]),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

    }

}