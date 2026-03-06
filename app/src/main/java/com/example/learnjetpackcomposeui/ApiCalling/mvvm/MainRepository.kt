package com.example.learnjetpackcomposeui.ApiCalling.mvvm

import com.example.learnjetpackcomposeui.ApiCalling.Models.PostModel
import com.example.learnjetpackcomposeui.ApiCalling.Models.UsersModel
import com.example.learnjetpackcomposeui.ApiCalling.Network.RetrofitClient

class MainRepository {

    suspend fun getPosts(): List<PostModel>{
        return RetrofitClient.api.getPosts()

    }

    suspend fun getUsers(): List<UsersModel> {
        return RetrofitClient.api.getUsers()
    }

}