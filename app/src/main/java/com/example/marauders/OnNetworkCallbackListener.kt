package com.example.marauders

import okhttp3.ResponseBody
import retrofit2.Retrofit


interface OnNetworkCallbackListener {
    fun onResponse(user: User?, retrofit: Retrofit?)
    fun onBodyError(responseBodyError: ResponseBody?)
    fun onBodyErrorIsNull()
    fun onFailure(t: Throwable?)
}