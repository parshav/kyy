package com.pv.kyy

import androidx.fragment.app.Fragment
import com.pv.kyy.ui.main.MainFragment

class MainActivity : BaseActivity() {

    override fun fragment(): Fragment = MainFragment.newInstance()
}