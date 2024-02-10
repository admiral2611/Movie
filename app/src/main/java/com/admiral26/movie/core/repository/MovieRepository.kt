package com.admiral26.movie.core.repository

import android.util.Log
import com.admiral26.movie.core.model.footerRes.FooterRespons
import com.admiral26.movie.core.model.headerRes.HeaderRespons
import com.admiral26.movie.core.network.ApiClient
import com.admiral26.movie.core.util.ResultWrapper
import com.admiral26.movie.core.util.parseData
import kotlinx.coroutines.Dispatchers
import java.io.IOException

class MovieRepository {

    private val service = ApiClient.createService()

   suspend fun getMoviesHed(): ResultWrapper<HeaderRespons, Any> {
       return parseData(Dispatchers.IO) {
           service.getHeader("10137bab07a7a987b23a902a78d6986c")
       }
   }

    suspend fun getMoviesFoot():ResultWrapper<FooterRespons,Any>{
        return try {

            val result = service.getFooter("10137bab07a7a987b23a902a78d6986c")
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