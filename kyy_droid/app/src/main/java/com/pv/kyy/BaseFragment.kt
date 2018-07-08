package com.pv.kyy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import arrow.core.*
import com.pv.kyy.ui.main.MainViewModel
import com.pv.kyy.ui.main.NextFiveData

abstract class BaseFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

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
        start()
        when (runFn()) {
            is Some -> Log.d("pv", "run : ${runFn().some()}")
            is None -> Log.d("pv", "Failed")
        }

        fetch().map {
            when (it) {
                is LaunchData.LaunchNextAmount -> {
                    Log.d("pv", "Fetch network data")
                }
                else -> {}
            }
        }
    }
    abstract fun layout(): LayoutId

    abstract fun start()

    open fun fetch(): Either<None, LaunchData> = None.left()

    open fun runFn(): FragmentFunction = None

}

fun LayoutId.unwrap(): Int = when (this) {
    is Some -> this.t
    is None -> R.layout.default_layout
}