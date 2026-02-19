package com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp

import android.util.Patterns
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.ui.theme.greyColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.learnjetpackcomposeui.ui.theme.*


@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

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

            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Image",
                modifier = Modifier

                    .width(120.dp)
                    .height(100.dp),
            )

            Spacer(Modifier.height(20.dp))
            Text(
                text = "WELCOME BACK!",
                fontSize = 24.sp,
                color = darkBlueColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Login to your account", fontSize = 14.sp, color = darkBlueColor
            )
            Spacer(Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // --- Email ---
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = null
                    },
                    placeholder = { Text("Email", fontSize = 14.sp) },
                    leadingIcon = {
                        Icon(Icons.Default.Email, contentDescription = null)
                    },
                    singleLine = true,
                    isError = emailError != null,   // 👈 ADD THIS
                    textStyle = TextStyle(
                        color = darkBlueColor,
                        fontSize = 14.sp
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )

                if (emailError != null) {
                    Text(
                        text = emailError!!,
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    )
                }


                Spacer(modifier = Modifier.height(20.dp))

                // --- Password ---
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = null
                    },
                    placeholder = { Text("Password", fontSize = 14.sp) },
                    leadingIcon = {
                        Icon(Icons.Default.Lock, contentDescription = null)
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Icon(
                                imageVector = if (passwordVisible)
                                    Icons.Filled.Visibility
                                else
                                    Icons.Filled.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    },
                    singleLine = true,
                    isError = passwordError != null,   // 👈 ADD THIS
                    visualTransformation = if (passwordVisible)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = TextStyle(
                        color = darkBlueColor,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                if (passwordError != null) {
                    Text(
                        text = passwordError!!,
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    )
                }


                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {

//                        var isValid = true
//
//                        // Email Validation
//                        if (email.isBlank()) {
//                            emailError = "Email cannot be empty"
//                            isValid = false
//                        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                            emailError = "Enter valid email"
//                            isValid = false
//                        }
//
//                        // Password Validation
//                        if (password.isBlank()) {
//                            passwordError = "Password cannot be empty"
//                            isValid = false
//                        } else if (password.length < 6) {
//                            passwordError = "Password must be at least 6 characters"
//                            isValid = false
//                        }
//
//                        if (isValid) {
                            navController.navigate("dashboard"){
                                popUpTo("login") { inclusive = true }
                            }
//                        }
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
                        text = "Login",
                        color = colorResource(id = R.color.white),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {

                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = greyColor

                    )

                    Text(
                        text = "Forgot Password?",
                        color = darkBlueColor,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 20.dp)

                    )

                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = greyColor
                    )


                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier.size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(40.dp))

                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't have an account? ",
                        fontSize = 12.sp,
                        color = darkBlueColor,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "SignUp",
                        fontSize = 12.sp,
                        color = darkBlueColor,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.navigate("Signup")
                        }

                    )
                }

            }

        }

    }


}