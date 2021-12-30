package com.example.interview_musicplayer

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var imageView: ImageView
    fun setData(resultsDTO: ResultsDTO) {
        textView = itemView.findViewById(R.id.text)
        textView2 = itemView.findViewById(R.id.text2)
        textView3 = itemView.findViewById(R.id.text3)
        textView4 = itemView.findViewById(R.id.text4)
        imageView = itemView.findViewById(R.id.image)
        textView.text =resultsDTO.artistName
       textView2.text = resultsDTO.country
       textView3.text = resultsDTO.kind
       textView4.text = resultsDTO.artistViewUrl
        Glide.with(imageView).load(resultsDTO.artworkUrl100).into(imageView)
    }
}