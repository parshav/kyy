package com.pv.kyy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter(
) : RecyclerView.Adapter<BaseViewHolder>() {

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout().unwrap(), parent, false)
        return BaseViewHolder(v)
    }

    final override fun getItemCount(): Int {
    }

    final override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }
    abstract fun layout(): LayoutId
}

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)