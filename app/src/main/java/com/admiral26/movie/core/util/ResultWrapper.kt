package com.admiral26.movie.core.util

sealed class ResultWrapper<out S, out E> {
    data class Success<out S>(val code: Int? = null, val response: S? = null) :
        ResultWrapper<S, Nothing>()

    data class ErrorResponse<out E>(val code: Int? = null, val error: E?) :
        ResultWrapper<Nothing, E>()

    data class NetworkError(val code: Int? = null, val error: String? = null) :
        ResultWrapper<Nothing, Nothing>()
}