package com.pv.kyy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.some
import com.pv.kyy.ui.main.MainViewModel

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
            is Some -> runFn().some()
            is None -> Log.d("pv", "Failed")
        }
    }
    abstract fun layout(): LayoutId

    abstract fun start()

    open fun runFn(): Option<() -> Boolean> = None
}

fun LayoutId.unwrap(): Int = when (this) {
    is Some -> this.t
    is None -> R.layout.default_layout
}