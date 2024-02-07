package com.admiral26.movie.core.util

sealed class ResultWrapper<out S, out E> {

    data class Success<S>(val response: S? = null, val code: Int? = null) :
        ResultWrapper<S, Nothing>()

    data class Error<E>(val message: E? = null, val code: Int? = null) :
        ResultWrapper<Nothing, E>()

}