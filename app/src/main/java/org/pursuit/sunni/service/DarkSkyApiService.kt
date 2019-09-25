package org.pursuit.sunni.service

import android.view.Display
import org.pursuit.sunni.Model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DarkSkyApiService {
    @GET("forecast")
    fun getDailyForecast(@Query("key") key: String, @Query("lat") lat: String, @Query("lon") lon: String): Call<Model>


}