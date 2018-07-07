package com.pv.kyy.ui.main

import arrow.core.Option
import arrow.core.none
import arrow.core.some
import com.pv.kyy.*

object MainFragment : BaseFragment() {

    override fun layout(): LayoutId = none()

    override fun start() {
    }

    override fun runFn(): FragmentFunction = getTrue()

    private fun getTrue() = { true }.some()
}
