package com.pv.kyy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pv.kyy.networking.LaunchResult
import java.io.Serializable

//class RecyclerData<T : LaunchResult>(elements: Array<T>) : Serializable
typealias recyclerdata = Pair<LaunchResult, LayoutId>

class BaseRecyclerAdapter(
     recyclerData: recyclerdata
) : RecyclerView.Adapter<BaseViewHolder>() {

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout().unwrap(), parent, false)
        return BaseViewHolder(v)
    }

    final override fun getItemCount(): Int = 0

    final override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }
    abstract fun layout(): LayoutId
}

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}