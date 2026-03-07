package com.example.learnjetpackcomposeui.ApiCallingDI.mvvm

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learnjetpackcomposeui.ApiCallingDI.CreateUserRequest

@Composable
fun UserScreen(

    viewModel: MainViewModel = hiltViewModel()

) {

    val state by viewModel.users.collectAsState()
    val createUserState by viewModel.createUser.collectAsState()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getUsers()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // -------- USER INPUT --------

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if(email.isEmpty() || name.isEmpty()){
                    Toast.makeText(context, "Please add all fields", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                val request = CreateUserRequest(
                    name = name,
                    email = email
                )

                viewModel.createUser(request)

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create User")
        }



        Spacer(modifier = Modifier.height(16.dp))

        // -------- POST RESULT --------

        when (createUserState) {

            is NetworkResult.Loading -> {
                Text("Creating user...")
            }

            is NetworkResult.Success -> {

                val user =
                    (createUserState as NetworkResult.Success).data

                Text("User Created: ${user.name}")
                viewModel.getUsers()
                name = ""
                email = ""
            }

            is NetworkResult.Error -> {

                Text(
                    "Error: ${(createUserState as NetworkResult.Error).message}"
                )
            }

            null -> {}
        }

        Spacer(modifier = Modifier.height(20.dp))

        // -------- GET USERS --------

        when (state) {

            is NetworkResult.Loading -> {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is NetworkResult.Success -> {

                val users =
                    (state as NetworkResult.Success).data

                LazyColumn {

                    items(users) {

                        Text(
                            text = it.name,
                            modifier = Modifier.padding(12.dp)
                        )

                    }
                }
            }

            is NetworkResult.Error -> {

                Text(
                    text = (state as NetworkResult.Error).message
                )
            }
        }
    }
}