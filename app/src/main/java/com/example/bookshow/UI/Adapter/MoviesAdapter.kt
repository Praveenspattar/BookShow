package com.example.bookshow.UI.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookshow.R

class MoviesAdapter(private val context: Context,private val movieImages: List<Int>) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_itemview, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieImages.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.movieImage.setBackgroundResource(movieImages[position])
    }

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieImage: ImageView = itemView.findViewById(R.id.item_image)
    }
}
