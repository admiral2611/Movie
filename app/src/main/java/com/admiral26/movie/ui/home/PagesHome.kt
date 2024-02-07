package com.admiral26.movie.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movie.R
import com.admiral26.movie.core.adapter.MultiAdapter
import com.admiral26.movie.core.base.BaseFragment
import com.admiral26.movie.core.model.BaseModel
import com.admiral26.movie.databinding.HomePageBinding

class PagesHome : BaseFragment(R.layout.home_page) {
    private val binding by viewBinding(HomePageBinding::bind)
    private val homeLD: HomeViewModel by viewModels()
    private val multiData = ArrayList<BaseModel>()
    private val adapter by lazy { MultiAdapter() }
    private var one = false
    private var two = false


    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        homeLD.getHead()
        homeLD.getFoot()
        loadAdapter()
        observe()
    }

    private fun observe() {
        homeLD.movieListLD.observe(requireActivity()) {
            multiData.add(it)
            one = true
            if (this.one &&two){
                this.adapter.setData(multiData)
            }
        }
        homeLD.movieFootListLD.observe(requireActivity()) {
            multiData.add(it)
            two = true
            if (one&& this.two){
                this.adapter.setData(multiData)
            }

        }
    }

    private fun loadAdapter() {
        multiData.clear()
        binding.multiRvList.adapter = adapter
        binding.multiRvList.layoutManager = LinearLayoutManager(context)
        binding.multiRvList.setHasFixedSize(true)
    }
}