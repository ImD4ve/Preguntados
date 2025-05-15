package com.example.preguntados
import android.app.Application

class PreguntadosApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseInitializer.initialize(this)
    }
}