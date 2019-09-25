package org.pursuit.sunni.Model

object Model {
    data class Result(val currently: Currently, val daily: Daily)
    data class Currently(val temperature: Int)
    data class Daily(val summary: String, val icon: String, val data: List<Data>)
    data class Data(val time: Int, val summary: String, val icon: String)
}