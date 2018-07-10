package com.pv.kyy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import arrow.core.*
import com.pv.kyy.networking.EndPoints
import com.pv.kyy.networking.LaunchResult
import com.pv.kyy.networking.NewLaunchData
import com.pv.kyy.networking.getNextTenByFuel
import com.pv.kyy.ui.main.MainViewModel
import io.reactivex.subjects.BehaviorSubject

abstract class BaseFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val endpoints = EndPoints

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(layout().unwrap(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        subscribeForData()
        when (runFn()) {
            is Some -> Log.d("pv", "run : ${runFn().some()}")
            is None -> Log.d("pv", "Failed")
        }

        fetch().map {
            when (it) {
                is LaunchData.LaunchNextAmount -> {
                    endpoints.getNextTenByFuel(dataObservable = dataObservable())
//                    dataUpdate(LaunchResult.LaunchData("").right())
                }
                else -> {
                }
            }
        }
    }

    abstract fun layout(): LayoutId

    abstract fun dataUpdate(data: NewLaunchData)

    abstract fun dataObservable(): BehaviorSubject<NewLaunchData>

    open fun subscribeForData() {}

    open fun fetch(): Either<None, LaunchData> = None.left()

    open fun runFn(): FragmentFunction = None

}

fun LayoutId.unwrap(): Int = when (this) {
    is Some -> this.t
    is None -> R.layout.default_layout
}