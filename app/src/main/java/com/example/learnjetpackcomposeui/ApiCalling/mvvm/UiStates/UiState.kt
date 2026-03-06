package com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates

import com.example.learnjetpackcomposeui.ApiCalling.Models.PostModel

sealed class UiState {
    object Loading : UiState()

    data class Success(val data: List<PostModel>) : UiState()

    data class Error(val message: String) : UiState()
}