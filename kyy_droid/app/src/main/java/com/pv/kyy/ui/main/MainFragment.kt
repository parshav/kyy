package com.pv.kyy.ui.main

import android.support.v7.widget.RecyclerView
import arrow.core.Option
import arrow.core.none
import arrow.core.some
import com.pv.kyy.*

object MainFragment : BaseFragment() {

    private val recyclerView: RecyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recycler_view) }

    private val setupRecyclerView= {
        true
    }.some()

    override fun layout(): LayoutId = none()

    override fun start() {}

    override fun runFn(): FragmentFunction = setupRecyclerView
}
