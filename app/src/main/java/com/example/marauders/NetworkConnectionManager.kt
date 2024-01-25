package com.example.marauders

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkConnectionManager {
    fun callServer(listener: OnNetworkCallbackListener?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .build()
        val git = retrofit.create(GitHubService::class.java)
        val call = git.getUser()

//        var a = call?.body()
//        var b = a

        call?.enqueue(object  : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {

                val user = response.body()

                if (user == null) {
                    //404 or the response cannot be converted to User.
                    val responseBody = response.errorBody()
                    if (responseBody != null) {
                        listener!!.onBodyError(responseBody)
                    } else {
                        listener!!.onBodyErrorIsNull()
                    }
                } else {
                    //200
                    listener!!.onResponse(user, retrofit)
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {

                if (listener != null) {
                    listener.onFailure(t)
                }
            }

        })

    }
}