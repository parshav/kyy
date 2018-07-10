package com.pv.kyy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.pv.kyy.networking.LaunchResult
import com.pv.kyy.ui.main.RecyclerDataBinder

//class RecyclerData<T : LaunchResult>(elements: Array<T>) : Serializable
typealias RecyclerItemLayout = Pair<Int, RecyclerDataBinder>
typealias Recyclerdata = Pair<LaunchResult, RecyclerItemLayout>

fun Recyclerdata.unwrapLayout(): Int = this.second.first

class BaseRecyclerAdapter(
     private val recyclerData: Recyclerdata
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(recyclerData.unwrapLayout(), parent, false)
        return BaseViewHolder(v)
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }
}

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}