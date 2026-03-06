package com.example.learnjetpackcomposeui.ApiCalling.Network

import com.example.learnjetpackcomposeui.ApiCalling.Models.PostModel
import com.example.learnjetpackcomposeui.ApiCalling.Models.UsersModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts(): List<PostModel>

    @GET("users")
    suspend fun getUsers(): List<UsersModel>
}