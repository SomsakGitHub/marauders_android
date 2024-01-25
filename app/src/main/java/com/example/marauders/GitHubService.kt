package com.example.marauders

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("api/v1/auth/healthCheck")
    fun getUser(): Call<User?>?
    //fun getUser(): Response<User?>?
}