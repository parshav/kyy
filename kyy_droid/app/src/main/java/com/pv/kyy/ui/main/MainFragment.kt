package com.pv.kyy.ui.main

import arrow.core.Option
import arrow.core.none
import arrow.core.some
import com.pv.kyy.BaseFragment
import com.pv.kyy.FragmentFunctions
import com.pv.kyy.LayoutId
import com.pv.kyy.R

object MainFragment : BaseFragment() {

    override fun layout(): LayoutId = none()

    override fun start() {
    }

    override fun runFn(): Option<() -> Boolean> {
        return getTrue()
    }

    fun getTrue() = { true }.some()
}
