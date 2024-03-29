package com.admiral26.movie.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movie.R
import com.admiral26.movie.core.adapter.MultiAdapter
import com.admiral26.movie.core.base.BaseFragment
import com.admiral26.movie.core.model.footerRes.FooterRespons
import com.admiral26.movie.core.model.headerRes.HeaderRespons
import com.admiral26.movie.databinding.HomePageBinding

class PagesHome : BaseFragment(R.layout.home_page) {
    private val binding by viewBinding(HomePageBinding::bind)
    private val homeLD: HomeViewModel by viewModels()
    private val data = MediatorLiveData<Pair<HeaderRespons?, FooterRespons?>>()
    private val adapter by lazy { MultiAdapter() }


    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        homeLD.getHead()
        homeLD.getFoot()
        loadAdapter()
        observe()
    }

    private fun observe() {

        data.addSource(homeLD.movieListLD) {
            data.value = Pair(it, data.value?.second)
        }

        data.addSource(homeLD.movieFootListLD) {
            data.value = Pair(data.value?.first, it)
        }

        data.observe(viewLifecycleOwner) {
            val data1 = it.first
            val data2 = it.second

            if (data1 != null && data2 != null) {
                adapter.addData(data1)
                adapter.addData(data2)
            }
        }
    }

    private fun loadAdapter() {

        binding.multiRvList.adapter = adapter
        binding.multiRvList.layoutManager = LinearLayoutManager(context)
    }
}