package org.pursuit.sunni.View

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.pursuit.sunni.Model.Model
import org.pursuit.sunni.R
import org.pursuit.sunni.service.DarkSkyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val API_KEY: String = "275204eecb812ca599bd354dfa91525b"

class MainActivity : AppCompatActivity() {
    private val LATITUDE: Double = 37.8267
    private val LONGIGTUDE: Double = -122.4233
    private val TAG: String = "onNetworkRequest"

    val darkSkyService by lazy {
        DarkSkyApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestWeather()


    }

    private fun requestWeather() {
        val call =
            darkSkyService.getDailyForecast(API_KEY, LATITUDE.toString(), LONGIGTUDE.toString())
        call.enqueue(object : Callback<Model.Result> {
            override fun onFailure(call: Call<Model.Result>, t: Throwable) {
                Log.d(TAG, t.message)
            }

            override fun onResponse(call: Call<Model.Result>, response: Response<Model.Result>) {

                Log.d(TAG, "Success!")

            }
        })

    }
}
