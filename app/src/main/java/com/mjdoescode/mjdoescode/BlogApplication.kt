package com.mjdoescode.mjdoescode

import android.app.Application
import com.mjdoescode.mjdoescode.data.AppContainer
import com.mjdoescode.mjdoescode.data.DefaultAppContainer

class BlogApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}