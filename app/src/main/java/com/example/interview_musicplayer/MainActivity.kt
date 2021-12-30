package com.example.interview_musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var adapter: MusicAdapter
    private lateinit var responseDTO:ResponseDTO

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.Searchbox)
        recyclerView = findViewById(R.id.recyclerView)
        button.setOnClickListener {
            var apiService = Network.getRetrofitInstance().create(ApiService::class.java)
            apiService.getUser(editText.text.toString()).enqueue(object : retrofit2.Callback<ResponseDTO>{
                override fun onResponse(p0: Call<ResponseDTO>, p1: Response<ResponseDTO>) {
                   if(p1.body()!=null){
                       responseDTO = p1.body()!!
                     // array.add(p1.body()!!)
                       setRecyclerView()
                   }
                }

                override fun onFailure(p0: Call<ResponseDTO>, p1: Throwable) {
                 Log.d("Nimit", "{$p1.message}")
                }

            })
        }
    }

    private fun setRecyclerView() {

        var layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        adapter = MusicAdapter(responseDTO)
        recyclerView.adapter = adapter

    }
}