package com.example.androidsdktutorial

import android.app.Application
import io.karte.android.KarteApp

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KarteApp.setup(this)
        // ここにアプリケーションの初期化や共通の処理を記述します
    }
}
