package com.admiral26.movie.core.di

import com.admiral26.movie.core.network.service.MovieService
import com.admiral26.movie.core.repository.MovieRepository
import org.koin.dsl.module

val repoModule = module {
    single<MovieRepository> {
        MovieRepository(get<MovieService>())
    }
}