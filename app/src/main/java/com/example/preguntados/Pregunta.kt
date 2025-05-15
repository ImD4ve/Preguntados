package com.example.preguntados
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preguntas")
data class Pregunta(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoria: String,
    val texto: String,
    val opcion1: String,
    val opcion2: String,
    val opcion3: String,
    val opcion4: String,
    val respuestaCorrecta: Int, // 0-3
    var usada: Boolean = false
)