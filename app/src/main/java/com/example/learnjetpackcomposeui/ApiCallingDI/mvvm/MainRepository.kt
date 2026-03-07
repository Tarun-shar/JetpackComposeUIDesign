package com.example.learnjetpackcomposeui.ApiCallingDI.mvvm

import com.example.learnjetpackcomposeui.ApiCalling.Models.UsersModel
import com.example.learnjetpackcomposeui.ApiCallingDI.CreateUserRequest
import com.example.learnjetpackcomposeui.ApiCallingDI.NetworkDI.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getUsers(): NetworkResult<List<UsersModel>> {

        return try {

            val response = apiService.getUsers()

            if (response.isSuccessful) {

                NetworkResult.Success(
                    response.body() ?: emptyList()
                )

            } else {

                NetworkResult.Error(response.message())
            }

        } catch (e: Exception) {

            NetworkResult.Error(e.message ?: "Unknown Error")
        }
    }


    suspend fun createUser(
        request: CreateUserRequest
    ): NetworkResult<UsersModel> {

        return try {

            val response = apiService.createUser(request)

            if (response.isSuccessful) {

                response.body()?.let {

                    NetworkResult.Success(it)

                } ?: NetworkResult.Error("Empty Response")

            } else {

                NetworkResult.Error(response.message())

            }

        } catch (e: Exception) {

            NetworkResult.Error(e.message ?: "Unknown Error")

        }
    }
}