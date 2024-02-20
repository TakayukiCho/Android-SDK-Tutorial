package com.example.androidsdktutorial

import android.app.Application
import io.karte.android.KarteApp
import io.karte.android.variables.Variables

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KarteApp.setup(this)
        Variables.fetch()
    }
}
