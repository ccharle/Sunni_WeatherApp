package org.pursuit.sunni.service

import android.view.Display
import okhttp3.OkHttpClient
import org.pursuit.sunni.Model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DarkSkyApiService {
    @GET("forecast")
    fun getDailyForecast(@Query("key") key: String, @Query("lat") lat: String, @Query("lon") lon: String): Call<Model.Result>

    companion object {
        private const val BASE_URL: String = "https://api.darksky.net/forecast/"

        fun create(): DarkSkyApiService {
            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            val client: OkHttpClient = builder.build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
            return retrofit.create(DarkSkyApiService::class.java)


        }


    }
}