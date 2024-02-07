package com.admiral26.movie.core.repository

import android.util.Log
import com.admiral26.movie.core.model.footerRes.FooterRespons
import com.admiral26.movie.core.model.headerRes.HeaderRespons
import com.admiral26.movie.core.network.ApiClient
import com.admiral26.movie.core.util.ResultWrapper
import java.io.IOException

class MovieRepository {

    private val service = ApiClient.createService()
    private val servicefoot = ApiClient.createService()

   suspend fun getMoviesHed(): ResultWrapper<HeaderRespons, Any> {
        return try {
            val result = service.getHeader("10137bab07a7a987b23a902a78d6986c")
            if (result.isSuccessful){
                Log.d("bodyHead", "getMoviesFoot: ${result.body().toString()}")

                ResultWrapper.Success(result.body(),result.code())
            }else{
                ResultWrapper.Error(result.message(),result.code())
            }
        }catch (e: IOException) {
            ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }

    suspend fun getMoviesFoot():ResultWrapper<FooterRespons,Any>{
        return try {

            val result = servicefoot.getFooter("10137bab07a7a987b23a902a78d6986c")
            if (result.isSuccessful){
                Log.d("bodyFoot", "getMoviesFoot: ${result.body().toString()}")
                ResultWrapper.Success(result.body(),result.code())
            }else{
                ResultWrapper.Error(result.message(),result.code())
            }
        }catch (e: IOException) {
            ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }
}