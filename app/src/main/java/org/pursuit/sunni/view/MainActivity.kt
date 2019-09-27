package org.pursuit.sunni.view

import android.os.Bundle
import android.util.Log
import android.view.Display
import android.widget.CursorTreeAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.pursuit.sunni.adapter.WeatherAdapter
import org.pursuit.sunni.model.Model
import org.pursuit.sunni.R
import org.pursuit.sunni.model.Currently
import org.pursuit.sunni.service.DarkSkyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val API_KEY: String = "275204eecb812ca599bd354dfa91525b"

class MainActivity : AppCompatActivity() {
    private val LATITUDE_LONGITUDE: String = "42.3601,-71.0589"
    private val TAG: String = "onNetworkRequest"
    private var dailyWeatherList = ArrayList<Model>()

    private val darkSkyService by lazy {
        DarkSkyApiService.create()
            .getDailyForecast(API_KEY, LATITUDE_LONGITUDE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestWeather()
        ryclrvw_dailyforecast.layoutManager = LinearLayoutManager(this)


    }

    private fun requestWeather() {
        darkSkyService.enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.d(TAG, "Failure!")
            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful) {
                    dailyWeatherList.add(response.body()!!)
                    ryclrvw_dailyforecast.adapter = WeatherAdapter(dailyWeatherList)

                } else {
                    Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_LONG).show()
                }
                Log.d(TAG, "Success!")
            }
        })
    }
}
