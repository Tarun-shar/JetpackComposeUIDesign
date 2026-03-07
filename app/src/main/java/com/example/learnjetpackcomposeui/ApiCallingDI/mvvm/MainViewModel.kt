package com.example.learnjetpackcomposeui.ApiCallingDI.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnjetpackcomposeui.ApiCalling.Models.UsersModel
import com.example.learnjetpackcomposeui.ApiCallingDI.CreateUserRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {

    private val _users =
        MutableStateFlow<NetworkResult<List<UsersModel>>>(
            NetworkResult.Loading()
        )
    val users: StateFlow<NetworkResult<List<UsersModel>>> =
        _users

    // create User
    private val _createUser =
        MutableStateFlow<NetworkResult<UsersModel>?>(null)
    val createUser: StateFlow<NetworkResult<UsersModel>?> = _createUser

    fun getUsers() {

        viewModelScope.launch {

            _users.value = NetworkResult.Loading()

            _users.value = repository.getUsers()

        }
    }

    fun createUser(request: CreateUserRequest){
        viewModelScope.launch {

            _createUser.value = NetworkResult.Loading()

            _createUser.value = repository.createUser(request)
        }
    }

}