package com.pv.kyy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import arrow.core.Option

typealias LayoutId = Option<Int>
typealias FragmentFunction = Option<() -> Boolean>

abstract class BaseActivity : AppCompatActivity() {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment())
            .commitNow()
        }
    }

    abstract fun fragment(): Fragment
}
