package com.example.preguntados
import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log


class PreguntadosApp : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            // Inicialización diferida
            Handler(Looper.getMainLooper()).postDelayed({
                AppDatabase.getDatabase(this)
            }, 500)
        } catch (e: Exception) {
            Log.e("PreguntadosApp", "Error en inicialización", e)
        }
    }
}