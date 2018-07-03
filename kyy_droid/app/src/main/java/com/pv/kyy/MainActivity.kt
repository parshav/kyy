package com.pv.kyy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pv.kyy.Arw.Core
import com.pv.kyy.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        val a = Core()
        a.tes()
    }

}
