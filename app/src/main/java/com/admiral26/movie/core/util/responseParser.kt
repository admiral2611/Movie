package com.admiral26.movie.core.util

import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.CoroutineContext

suspend inline fun <S, E> parseData(
    context: CoroutineContext,
    crossinline apiCall: suspend () -> Response<S?>
): ResultWrapper<S, E> {
    withContext(context) {
        try {
            val result = apiCall.invoke()
            // val result = service.getHeader("10137bab07a7a987b23a902a78d6986c")
            if (result.isSuccessful) {
                return@withContext ResultWrapper.Success(result.body(), result.code())
            } else {
                return@withContext ResultWrapper.Error(result.message(), result.code())
            }
        } catch (e: IOException) {
            return@withContext ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            return@withContext ResultWrapper.Error(e.message)
        }
    }
    return ResultWrapper.Error()
}