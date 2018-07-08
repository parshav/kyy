package com.pv.kyy.ui.main

//import android.support.v7.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView
import arrow.core.*
import com.pv.kyy.*

typealias NextFiveData = Either<LaunchData.NoDataError, LaunchData.LaunchNextAmount>

object MainFragment : BaseFragment() {

    private val recyclerView: RecyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recycler_view) }

    private val setupRecyclerView= {
        recyclerView
        true
    }.some()

    override fun layout(): LayoutId = none()

    override fun start() {}

    override fun runFn(): FragmentFunction = setupRecyclerView

    override fun fetch(): Either<None, LaunchData> = LaunchData.LaunchNextAmount().right()
}
