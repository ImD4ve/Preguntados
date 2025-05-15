package com.example.preguntados
import android.app.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PreguntaRepository(application: Application) {
    private val db = AppDatabase.getDatabase(application)
    private val dao = db.preguntaDao()

    suspend fun getUnansweredQuestion(category: String): Pregunta? {
        return withContext(Dispatchers.IO) {
            dao.getUnansweredQuestion(category)
        }
    }

    suspend fun markAsUsed(pregunta: Pregunta) {
        withContext(Dispatchers.IO) {
            dao.update(pregunta.apply { usada = true })
        }
    }

    suspend fun resetQuestions() {
        withContext(Dispatchers.IO) {
            dao.resetAll()
        }
    }
}