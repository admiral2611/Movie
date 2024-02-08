package com.admiral26.movie.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.admiral26.movie.core.model.BaseModel
import com.admiral26.movie.core.model.footerRes.FooterRespons
import com.admiral26.movie.core.model.headerRes.HeaderRespons
import com.admiral26.movie.databinding.ItemBannerHeaderBinding
import com.admiral26.movie.databinding.ItemFooterParentBinding

class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<BaseModel>()

    fun setData(multiData: ArrayList<BaseModel>) {
        this.data.clear()
        data.sortBy { it.getType() }
        this.data.addAll(multiData)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class BannerViewHolder(private val binding: ItemBannerHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = HeaderAdapter()

        fun bindDataToHeader(data: HeaderRespons) {
            binding.viewPagerHeader.adapter = adapter
            adapter.setData(data = data.results)
        }
    }

    inner class FootViewHolder(private val binding: ItemFooterParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter = FooterAdapter()
        fun bindDataToFoot(data: FooterRespons) {
            binding.rvList.adapter = adapter
            binding.rvList.layoutManager = LinearLayoutManager(binding.root.context)
            adapter.setDataFoot(data = data.resultFootArticles)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            BaseModel.TOP_HEAD_LINE -> {
                BannerViewHolder(
                    ItemBannerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                FootViewHolder(
                    ItemFooterParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
        }
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BaseModel.TOP_HEAD_LINE -> {
                (holder as BannerViewHolder).bindDataToHeader(data = data[position] as HeaderRespons)
            }

            BaseModel.FOOT_LINE -> {
                (holder as FootViewHolder).bindDataToFoot(data = data[position] as FooterRespons)
            }
        }
    }
}