package com.pv.kyy.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import arrow.core.EitherOf
import arrow.effects.IO
import arrow.effects.ap
import com.pv.kyy.R
import com.pv.kyy.networking.EndPoints
import com.pv.kyy.networking.LaunchResponse
import com.pv.kyy.networking.getNextTen
import com.pv.kyy.networking.getNextTenByFuel

class MainFragment : Fragment() {

    private val endpoint = EndPoints

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        val launchResponse = getNextTen().unsafeRunSync()
        Log.d("pv", "launch ; $launchResponse")
//        getNextTenByFuel()
    }
}
