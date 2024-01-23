package com.example.marauders

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{username}")
    fun getUser(@Path("username") username: String?): Call<User?>?
}