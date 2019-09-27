package org.pursuit.sunni.service

import android.view.Display
import okhttp3.OkHttpClient
import org.pursuit.sunni.model.Currently
import org.pursuit.sunni.model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DarkSkyApiService {
    @GET("forecast/{key}/{lat_long}")
    fun getDailyForecast(@Path("key") key: String, @Path("lat_long") lat: String): Call<Model>

    companion object {
        private const val BASE_URL: String = "https://api.darksky.net/"

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