package org.pursuit.sunni.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recyclerview_layout.*
import org.pursuit.sunni.model.Currently
import org.pursuit.sunni.model.Model

class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun onBind(result: Model) {
        txtvw_daily_summary.text = result.daily.summary
        txtvw_data_summary.text = result.daily.data[0].summary
        txtvw_data_time.text = result.daily.data[0].time.toString()
    }

}


