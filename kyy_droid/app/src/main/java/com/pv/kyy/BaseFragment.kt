package com.pv.kyy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import com.pv.kyy.ui.main.MainViewModel

abstract class BaseFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(layout().fetch(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        start()
    }
    abstract fun layout(): Option<LayoutRes>

    abstract fun start()
}

fun Option<LayoutRes>.fetch(): LayoutRes = when (this) {
    is Some -> this.t
    is None -> R.layout.default_layout
}