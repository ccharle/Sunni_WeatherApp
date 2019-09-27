package org.pursuit.sunni.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pursuit.sunni.R
import org.pursuit.sunni.model.Currently
import org.pursuit.sunni.model.Model
import org.pursuit.sunni.view.ViewHolder


class WeatherAdapter(private val weatherList: List<Model>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_layout,
                parent,
                false
            )
        )


    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(weatherList[position])
    }
}