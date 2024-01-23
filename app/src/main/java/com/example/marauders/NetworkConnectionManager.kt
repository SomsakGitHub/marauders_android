package com.example.marauders

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkConnectionManager {
    fun callServer(listener: OnNetworkCallbackListener?, username: String?) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val git = retrofit.create(GitHubService::class.java)
        val call = git.getUser(username)
        call?.enqueue(object  : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
//                TODO("Not yet implemented")

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
//                TODO("Not yet implemented")

                if (listener != null) {
                    listener.onFailure(t)
                }
            }

        })
//        val call: Call? = git.getUser(username)
//        call.enqueue(object : Callback<User?>() {
//            fun onResponse(response: Response<User?>?, retrofit: Retrofit?) {}
//            fun onFailure(t: Throwable?) {}
//        })
    }
}