package org.pursuit.sunni.View

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recyclerview_layout.*
import org.pursuit.sunni.Model.Model

class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun onBind(result: Model.Result) {
        txtvw_time.text = result.daily.data[0].time.toString()
    }


}


