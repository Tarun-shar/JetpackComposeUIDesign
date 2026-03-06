package com.example.learnjetpackcomposeui.ApiCalling.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnjetpackcomposeui.ApiCalling.Models.PostModel
import com.example.learnjetpackcomposeui.ApiCalling.mvvm.MainViewmodel
import com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates.UiState

@Composable
fun ShowApiData(viewmodel: MainViewmodel = viewModel()) {

    val context = LocalContext.current

    var posts by remember { mutableStateOf<List<PostModel>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {

        viewmodel.fetchPosts()

        viewmodel.state.collect { state ->
            when (state) {
                is UiState.Loading -> {
                    // Show loading indicator
                    isLoading = true
                }

                is UiState.Success -> {
                    isLoading = false
                    posts = state.data

                }

                is UiState.Error -> {
                    isLoading = false
                    // Show error message
                    Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    if(isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else{
        LazyColumn {

            items(posts) { post ->

                PostItem(post)

            }
        }
    }

}

@Composable
fun PostItem(post: PostModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = post.title,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = post.body)

        }
    }
}