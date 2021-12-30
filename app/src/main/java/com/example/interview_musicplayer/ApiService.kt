package com.example.interview_musicplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getUser(@Query("term") searchTerm :String) : Call<ResponseDTO>

}