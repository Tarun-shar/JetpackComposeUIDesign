package com.example.learnjetpackcomposeui.ApiCalling.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates.UiState
import com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates.UserUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewmodel : ViewModel() {

    private val repository = MainRepository()

    // 🔹 Posts UI State
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state


    // 🔹 Users UI State
    private val _userState = MutableStateFlow<UserUiState>(UserUiState.Loading)
    val userState: StateFlow<UserUiState> = _userState


    init {
        fetchPosts()
    }


    // 🔹 Fetch Posts
    fun fetchPosts() {

        viewModelScope.launch {

            _state.value = UiState.Loading

            try {

                val result = repository.getPosts()

                _state.value = UiState.Success(result)

            } catch (e: Exception) {

                _state.value = UiState.Error(e.message ?: "Unknown Error")

            }
        }
    }


    // 🔹 Fetch Users
    fun fetchUsers() {

        viewModelScope.launch {

            _userState.value = UserUiState.Loading

            try {

                val result = repository.getUsers()

                _userState.value = UserUiState.Success(result)

            } catch (e: Exception) {

                _userState.value = UserUiState.Error(e.message ?: "Error")

            }
        }
    }
}