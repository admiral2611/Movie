package com.admiral26.movie.core.di

import com.admiral26.movie.core.repository.MovieRepository
import com.admiral26.movie.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get<MovieRepository>())
    }
}