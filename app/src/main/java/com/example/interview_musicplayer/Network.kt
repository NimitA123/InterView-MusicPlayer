package com.example.interview_musicplayer

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
        private var httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getRetrofitInstance():Retrofit{
         var retrofit = Retrofit.Builder().baseUrl("https://itunes.apple.com/").addConverterFactory(GsonConverterFactory.create()).client(
            OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build()
            return retrofit

        }
    }
}