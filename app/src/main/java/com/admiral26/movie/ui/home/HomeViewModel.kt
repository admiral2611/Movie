package com.admiral26.movie.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admiral26.movie.core.model.footerRes.FooterRespons
import com.admiral26.movie.core.model.headerRes.HeaderRespons
import com.admiral26.movie.core.repository.MovieRepository
import com.admiral26.movie.core.util.ResultWrapper
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = MovieRepository()
    val movieListLD: MutableLiveData<HeaderRespons> = MutableLiveData()
    val movieFootListLD: MutableLiveData<FooterRespons> = MutableLiveData()
    val movieErrorLD: MutableLiveData<String> = MutableLiveData()


    fun getHead() {
        viewModelScope.launch {

            when (val result = repository.getMoviesHed()) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    result.response?.let {
                        movieListLD.value = it
                    }
                }
            }

        }
    }

    fun getFoot() {
        viewModelScope.launch {

            when (val result = repository.getMoviesFoot()) {
                is ResultWrapper.ErrorResponse -> {

                }

                is ResultWrapper.NetworkError -> {

                }

                is ResultWrapper.Success -> {
                    result.response?.let {
                        movieFootListLD.value = it
                    }
                }
            }
        }
    }
}