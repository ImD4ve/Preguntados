package com.example.preguntados
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PreguntaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PreguntaRepository(application)

    val lives = MutableLiveData(3)
    val currentQuestion = MutableLiveData<Pregunta?>()
    val errorMessage = MutableLiveData<String>()

    fun getQuestion(category: String) {
        viewModelScope.launch {
            try {
                currentQuestion.value = repository.getUnansweredQuestion(category)
                if (currentQuestion.value == null) {
                    errorMessage.value = "No hay más preguntas en esta categoría"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }

    fun checkAnswer(selectedOption: Int): Boolean {
        currentQuestion.value?.let { question ->
            if (selectedOption == question.respuestaCorrecta) {
                viewModelScope.launch {
                    repository.markAsUsed(question)
                }
                return true
            }
        }
        lives.value = lives.value?.minus(1)
        return false
    }

    fun resetGame() {
        viewModelScope.launch {
            lives.value = 3
            repository.resetQuestions()
        }
    }
}