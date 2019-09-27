package org.pursuit.sunni.model

data class Model(

    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val currently: Currently,
    val daily: Daily

)
//    data class Hourly(val summary: String, val icon: String, val data: List<Data>)
//    data class Data(val time: Int, val summary: String, val icon: String)