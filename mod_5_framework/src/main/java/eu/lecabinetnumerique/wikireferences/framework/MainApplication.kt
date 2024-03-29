package eu.lecabinetnumerique.wikireferences.framework

import android.app.Application
import android.content.Context

class MainApplication : Application() {

    companion object {
        private var instance: MainApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}