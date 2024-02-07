package com.admiral26.movie.core.adapter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.admiral26.movie.ui.home.PagesHome
import com.admiral26.movie.ui.save.PagesSave
import com.admiral26.movie.ui.ticket.PagesTicket

class MainAdapter(fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PagesHome()
            1 -> PagesTicket()
            else -> PagesSave()
        }
    }
}