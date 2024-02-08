package com.admiral26.movie.core.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movie.core.model.headerRes.ResultArticles
import com.admiral26.movie.databinding.ItemHeaderBinding
import com.bumptech.glide.Glide

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private val data = ArrayList<ResultArticles>()

    fun setData(data: List<ResultArticles>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    inner class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ResultArticles) {
            Log.d("tag11", "bindData: ${data.originalTitle}")
            Log.d("tag11", "bindData: ${data.voteAverage.toString()}")
            binding.titleFilm.text=data.originalTitle
            binding.ratingHed.text = data.voteAverage.toString()

            Glide.with(binding.cardView.context)
                .load("https://image.tmdb.org/t/p/original${data.posterPath}")
                .into(binding.cardView)


        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeaderAdapter.HeaderViewHolder {
        return HeaderViewHolder(
            ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HeaderAdapter.HeaderViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount()=data.size
}