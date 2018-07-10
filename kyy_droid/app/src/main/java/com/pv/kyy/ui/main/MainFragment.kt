package com.pv.kyy.ui.main

//import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import arrow.core.*
import arrow.product
import com.pv.kyy.*
import com.pv.kyy.networking.LaunchResult
import com.pv.kyy.networking.NewLaunchData
import com.pv.kyy.networking.NextFiveData.Launche
import io.reactivex.subjects.BehaviorSubject
import kotlin.properties.Delegates

typealias NextFiveData = Either<LaunchData.NoDataError, LaunchData.LaunchNextAmount>
typealias NextFiveRecyclerData = Pair<LaunchResult.LaunchTen, LayoutId>

interface RecyclerDataBinder {
    fun bind()
}

class NextFiveItemBinder(private val launch: Launche, private val itemView: View): RecyclerDataBinder {

    private val name by lazy { itemView.findViewById<TextView>(R.id.tv_name) }
    private val startTime by lazy { itemView.findViewById<TextView>(R.id.tv_start_time) }
    private val agency by lazy { itemView.findViewById<TextView>(R.id.tv_agency_name) }

    override fun bind() {
        name.text = launch.name
        startTime.text = launch.windowstart
        agency.text = launch.lsp.name
    }
}

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
                    { res ->
                        when (res) {
                            is LaunchResult.LaunchTen ->{
                                recyclerView.layoutManager = LinearLayoutManager(context)
                                recyclerView.adapter = BaseRecyclerAdapter(recyclerdata(res, R.layout.main_fragment.some()))
                                1
                            }
                            else -> {1 }
                        }
                    }
            )
        }
    }

    override fun dataObservable() = dataObservable

    override fun layout(): LayoutId = none()

    override fun runFn(): FragmentFunction = setupRecyclerView

    override fun fetch(): Either<None, LaunchData> = LaunchData.LaunchNextAmount().right()
}
