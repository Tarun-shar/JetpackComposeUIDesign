package com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates

import com.example.learnjetpackcomposeui.ApiCalling.Models.UsersModel


sealed class UserUiState {

    object Loading : UserUiState()

    data class Success(val data: List<UsersModel>) : UserUiState()

    data class Error(val message: String) : UserUiState()

}
