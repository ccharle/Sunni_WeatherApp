package org.pursuit.sunni.model

data class Currently (
    val time : Int,
    val summary : String,
    val icon : String,
    val nearestStormDistance : Int,
    val nearestStormBearing : Int,
    val precipIntensity : Int,
    val precipProbability : Int,
    val temperature : Double,
    val apparentTemperature : Double,
    val dewPoint : Double,
    val humidity : Double,
    val pressure : Double,
    val windSpeed : Double,
    val windGust : Double,
    val windBearing : Int,
    val cloudCover : Double,
    val uvIndex : Int,
    val visibility : Int,
    val ozone : Double
)