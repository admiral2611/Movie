package com.admiral26.movie.ui.main

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.admiral26.movie.R
import com.admiral26.movie.core.adapter.main.MainAdapter
import com.admiral26.movie.core.base.BaseFragment
import com.admiral26.movie.databinding.ScreenMainBinding

class MainScreen : BaseFragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.viewpager.isUserInputEnabled = false
        binding.bottomnavigationview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeMenu -> binding.viewpager.setCurrentItem(0, false)
                R.id.ticketMenu -> binding.viewpager.setCurrentItem(1,false)
                R.id.saveMenu -> binding.viewpager.setCurrentItem(2,false)
            }
            true
        }
    }
}