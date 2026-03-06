package com.example.learnjetpackcomposeui.ApiCalling.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates.UiState
import com.example.learnjetpackcomposeui.ApiCalling.mvvm.UiStates.UserUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewmodel: ViewModel() {

    private val repository = MainRepository()

    private val _state = MutableSharedFlow<UiState>()
    val state = _state.asSharedFlow()


    private val _userState = MutableSharedFlow<UserUiState>()
    val userState = _userState.asSharedFlow()

    fun fetchPosts() {

        viewModelScope.launch {

            _state.emit(UiState.Loading)

            try {

                val result = repository.getPosts()

                _state.emit(UiState.Success(result))

            } catch (e: Exception) {

                _state.emit(UiState.Error(e.message ?: "Unknown Error"))

            }
        }
    }


    fun fetchUsers() {

        viewModelScope.launch {

            _userState.emit(UserUiState.Loading)

            try {

                val result = repository.getUsers()

                _userState.emit(UserUiState.Success(result))

            } catch (e: Exception) {

                _userState.emit(UserUiState.Error(e.message ?: "Error"))

            }

        }

    }
}