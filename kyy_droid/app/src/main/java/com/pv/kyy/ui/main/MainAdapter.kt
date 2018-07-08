package com.pv.kyy.ui.main

import com.pv.kyy.BaseRecyclerAdapter
import com.pv.kyy.LayoutId

class MainAdapter(
        private val itemLayout: LayoutId
) : BaseRecyclerAdapter() {

    override fun layout(): LayoutId = itemLayout

}