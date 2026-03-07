package com.example.learnjetpackcomposeui.ApiCallingDI.NetworkDI

import com.example.learnjetpackcomposeui.ApiCalling.Models.UsersModel
import com.example.learnjetpackcomposeui.ApiCallingDI.CreateUserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<UsersModel>>

    @POST("users")
    suspend fun createUser(
        @Body request: CreateUserRequest
    ): Response<UsersModel>
}