package com.example.preguntados
import androidx.room.*


@Dao
interface PreguntaDao {
    @Insert
    suspend fun insert(pregunta: Pregunta)

    @Insert
    suspend fun insertAll(preguntas: List<Pregunta>)

    @Query("SELECT * FROM preguntas WHERE categoria = :categoria AND usada = 0 LIMIT 1")
    suspend fun getUnansweredQuestion(categoria: String): Pregunta?

    @Query("SELECT * FROM preguntas LIMIT 1")
    suspend fun getAnyQuestion(): Pregunta?

    @Update
    suspend fun update(pregunta: Pregunta)

    @Query("UPDATE preguntas SET usada = 0")
    suspend fun resetAll()
}