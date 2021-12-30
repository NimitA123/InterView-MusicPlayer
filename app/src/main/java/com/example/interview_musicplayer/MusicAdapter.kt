package com.example.interview_musicplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter
    (var responseDTO: ResponseDTO):RecyclerView.Adapter<MoviesViewHolder>() {
    override fun getItemCount(): Int {
       return responseDTO.results!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_ayout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        var resultsDTO:ResultsDTO =responseDTO.results?.get(position)!!
        holder.setData(resultsDTO)
    }
}