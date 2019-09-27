package org.pursuit.sunni.model


data class Daily (

    val summary : String,
    val icon : String,
    val data : List<Data>
) {
   data class Data (
        val time : Int,
        val summary : String,
        val icon : String,
        val sunriseTime : Int,
        val sunsetTime : Int,
        val moonPhase : Double

    )
}