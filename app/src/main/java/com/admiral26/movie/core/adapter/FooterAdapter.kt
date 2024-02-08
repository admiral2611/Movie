package com.admiral26.movie.core.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movie.core.model.footerRes.ResultFootArticle
import com.admiral26.movie.databinding.ItemFooterBinding
import com.bumptech.glide.Glide

class FooterAdapter : RecyclerView.Adapter<FooterAdapter.FootViewHolder>() {

    private val data = ArrayList<ResultFootArticle>()

    fun setDataFoot(data: List<ResultFootArticle>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class FootViewHolder(private val binding: ItemFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ResultFootArticle) {

            binding.title.text = data.originalTitle
            binding.textData.text = data.releaseDate
            Log.d("foot11", "bindData: ${data.originalTitle}")
            Glide.with(binding.shapeableImageView.context)
                .load("https://image.tmdb.org/t/p/original${data.posterPath}")
                .into(binding.shapeableImageView)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FooterAdapter.FootViewHolder {

        return FootViewHolder(
            ItemFooterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FooterAdapter.FootViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount()=data.size
}