package com.pv.kyy

import android.app.Application
import cat.mguellsegarra.myopic.Myopic

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Myopic.init(this)
    }
}