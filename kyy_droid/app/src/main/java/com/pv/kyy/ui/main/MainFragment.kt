package com.pv.kyy.ui.main

//import android.support.v7.widget.RecyclerView
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import arrow.core.*
import com.pv.kyy.*
import com.pv.kyy.networking.LaunchResult
import com.pv.kyy.networking.NewLaunchData
import io.reactivex.subjects.BehaviorSubject
import kotlin.properties.Delegates

typealias NextFiveData = Either<LaunchData.NoDataError, LaunchData.LaunchNextAmount>

object MainFragment : BaseFragment() {

    private val recyclerView: RecyclerView by lazy { view!!.findViewById<RecyclerView>(R.id.recycler_view) }

    private var data by Delegates.observable<NewLaunchData>(LaunchResult.InitialState.right()) {
        _, _, new ->
            Log.d("pv", "Delegate Data $new")
        }

    private val dataObservable: BehaviorSubject<NewLaunchData> = BehaviorSubject.create()

    private val setupRecyclerView= {
        recyclerView
        true
    }.some()

    override fun dataUpdate(data: NewLaunchData) {
        this.data = data
    }

    override fun subscribeForData() {
        dataObservable.subscribe {
            it.fold(
                    {
                        Log.d("pv", "error")
                    },
                    {
                        Log.d("pv", "Success")
                    }
            )
        }
    }
    override fun dataObservable() = dataObservable

    override fun layout(): LayoutId = none()

    override fun runFn(): FragmentFunction = setupRecyclerView

    override fun fetch(): Either<None, LaunchData> = LaunchData.LaunchNextAmount().right()
}
