package com.example.preguntados
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseInitializer {
    companion object {
        fun initialize(context: Context) {
            val db = AppDatabase.getDatabase(context)

            CoroutineScope(Dispatchers.IO).launch {
                if (db.preguntaDao().getAnyQuestion() == null) {
                    insertDefaultQuestions(db)
                }
            }
        }

        private suspend fun insertDefaultQuestions(db: AppDatabase) {
            val preguntas = listOf(
                // CIENCIA (15 preguntas)
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Cuál es el planeta más grande del sistema solar?",
                    opcion1 = "Tierra",
                    opcion2 = "Júpiter",
                    opcion3 = "Marte",
                    opcion4 = "Venus",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué partícula subatómica tiene carga positiva?",
                    opcion1 = "Electrón",
                    opcion2 = "Protón",
                    opcion3 = "Neutrón",
                    opcion4 = "Fotón",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Cuántos huesos tiene el cuerpo humano adulto?",
                    opcion1 = "206",
                    opcion2 = "300",
                    opcion3 = "150",
                    opcion4 = "412",
                    respuestaCorrecta = 0
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué gas necesitan las plantas para la fotosíntesis?",
                    opcion1 = "Oxígeno",
                    opcion2 = "Dióxido de carbono",
                    opcion3 = "Nitrógeno",
                    opcion4 = "Hidrógeno",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Cuál es el metal más abundante en la corteza terrestre?",
                    opcion1 = "Hierro",
                    opcion2 = "Aluminio",
                    opcion3 = "Oro",
                    opcion4 = "Cobre",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué planeta es conocido como el 'planeta rojo'?",
                    opcion1 = "Venus",
                    opcion2 = "Marte",
                    opcion3 = "Júpiter",
                    opcion4 = "Saturno",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Cuál es la velocidad de la luz en el vacío?",
                    opcion1 = "300,000 km/s",
                    opcion2 = "150,000 km/s",
                    opcion3 = "1,000,000 km/s",
                    opcion4 = "30 km/s",
                    respuestaCorrecta = 0
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué científico formuló la teoría de la relatividad?",
                    opcion1 = "Isaac Newton",
                    opcion2 = "Albert Einstein",
                    opcion3 = "Galileo Galilei",
                    opcion4 = "Stephen Hawking",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué elemento químico tiene el símbolo 'O'?",
                    opcion1 = "Oro",
                    opcion2 = "Osmio",
                    opcion3 = "Oxígeno",
                    opcion4 = "Oganesón",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Cuántos cromosomas tiene una célula humana normal?",
                    opcion1 = "23",
                    opcion2 = "46",
                    opcion3 = "64",
                    opcion4 = "32",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué planeta tiene anillos visibles desde la Tierra?",
                    opcion1 = "Marte",
                    opcion2 = "Venus",
                    opcion3 = "Saturno",
                    opcion4 = "Mercurio",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué tipo de animal es una ballena?",
                    opcion1 = "Pez",
                    opcion2 = "Anfibio",
                    opcion3 = "Reptil",
                    opcion4 = "Mamífero",
                    respuestaCorrecta = 3
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué inventó Alexander Graham Bell?",
                    opcion1 = "La bombilla",
                    opcion2 = "El teléfono",
                    opcion3 = "La radio",
                    opcion4 = "El automóvil",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Cuál es el órgano más grande del cuerpo humano?",
                    opcion1 = "Cerebro",
                    opcion2 = "Corazón",
                    opcion3 = "Piel",
                    opcion4 = "Hígado",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Ciencia",
                    texto = "¿Qué mide la escala Richter?",
                    opcion1 = "Velocidad del viento",
                    opcion2 = "Intensidad de terremotos",
                    opcion3 = "Temperatura",
                    opcion4 = "Humedad",
                    respuestaCorrecta = 1
                ),

                // QUÍMICA (15 preguntas)
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuál es el símbolo químico del oro?",
                    opcion1 = "Go",
                    opcion2 = "Au",
                    opcion3 = "Ag",
                    opcion4 = "Or",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué gas es esencial para la respiración humana?",
                    opcion1 = "Nitrógeno",
                    opcion2 = "Dióxido de carbono",
                    opcion3 = "Oxígeno",
                    opcion4 = "Hidrógeno",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuál es el elemento más abundante en el universo?",
                    opcion1 = "Oxígeno",
                    opcion2 = "Carbono",
                    opcion3 = "Hidrógeno",
                    opcion4 = "Hierro",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué elemento tiene el símbolo químico 'Na'?",
                    opcion1 = "Nitrógeno",
                    opcion2 = "Neón",
                    opcion3 = "Sodio",
                    opcion4 = "Níquel",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuál es el pH del agua pura?",
                    opcion1 = "5",
                    opcion2 = "7",
                    opcion3 = "8",
                    opcion4 = "10",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué metal es líquido a temperatura ambiente?",
                    opcion1 = "Mercurio",
                    opcion2 = "Plomo",
                    opcion3 = "Hierro",
                    opcion4 = "Oro",
                    respuestaCorrecta = 0
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuál es la fórmula química del agua?",
                    opcion1 = "CO2",
                    opcion2 = "H2O",
                    opcion3 = "NaCl",
                    opcion4 = "O2",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué elemento tiene el símbolo 'Fe'?",
                    opcion1 = "Flúor",
                    opcion2 = "Fósforo",
                    opcion3 = "Hierro",
                    opcion4 = "Francio",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuál es el gas más abundante en la atmósfera terrestre?",
                    opcion1 = "Oxígeno",
                    opcion2 = "Dióxido de carbono",
                    opcion3 = "Nitrógeno",
                    opcion4 = "Argón",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué proceso convierte líquidos en gases?",
                    opcion1 = "Condensación",
                    opcion2 = "Sublimación",
                    opcion3 = "Evaporación",
                    opcion4 = "Solidificación",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuántos elementos hay en la tabla periódica actualmente?",
                    opcion1 = "92",
                    opcion2 = "118",
                    opcion3 = "150",
                    opcion4 = "80",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué científico organizó la tabla periódica?",
                    opcion1 = "Marie Curie",
                    opcion2 = "Dmitri Mendeleiev",
                    opcion3 = "Albert Einstein",
                    opcion4 = "Isaac Newton",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué partícula tiene carga negativa?",
                    opcion1 = "Protón",
                    opcion2 = "Neutrón",
                    opcion3 = "Electrón",
                    opcion4 = "Núcleo",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Qué tipo de enlace comparten los átomos en el agua?",
                    opcion1 = "Iónico",
                    opcion2 = "Metálico",
                    opcion3 = "Covalente",
                    opcion4 = "Magnético",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Química",
                    texto = "¿Cuál es el elemento más ligero?",
                    opcion1 = "Helio",
                    opcion2 = "Hidrógeno",
                    opcion3 = "Oxígeno",
                    opcion4 = "Litio",
                    respuestaCorrecta = 1
                ),

                // ARTE (15 preguntas)
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Quién pintó 'La noche estrellada'?",
                    opcion1 = "Pablo Picasso",
                    opcion2 = "Vincent van Gogh",
                    opcion3 = "Salvador Dalí",
                    opcion4 = "Claude Monet",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué movimiento artístico es conocido por sus formas geométricas?",
                    opcion1 = "Surrealismo",
                    opcion2 = "Cubismo",
                    opcion3 = "Impresionismo",
                    opcion4 = "Expresionismo",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Cuál es la escultura famosa de Miguel Ángel en Florencia?",
                    opcion1 = "El Pensador",
                    opcion2 = "David",
                    opcion3 = "Venus de Milo",
                    opcion4 = "El Beso",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué artista pintó el techo de la Capilla Sixtina?",
                    opcion1 = "Leonardo da Vinci",
                    opcion2 = "Miguel Ángel",
                    opcion3 = "Rafael",
                    opcion4 = "Donatello",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué pintor español es conocido por su período azul?",
                    opcion1 = "Salvador Dalí",
                    opcion2 = "Pablo Picasso",
                    opcion3 = "Joan Miró",
                    opcion4 = "Francisco Goya",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué obra es de Leonardo da Vinci?",
                    opcion1 = "La persistencia de la memoria",
                    opcion2 = "La Gioconda",
                    opcion3 = "Los girasoles",
                    opcion4 = "El grito",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué artista es conocido por pintar relojes derretidos?",
                    opcion1 = "Pablo Picasso",
                    opcion2 = "Salvador Dalí",
                    opcion3 = "Vincent van Gogh",
                    opcion4 = "Claude Monet",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué museo alberga la Mona Lisa?",
                    opcion1 = "Museo del Prado",
                    opcion2 = "Museo del Louvre",
                    opcion3 = "Museo Metropolitano",
                    opcion4 = "Galería Uffizi",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué estilo artístico se caracteriza por pinceladas pequeñas y visibles?",
                    opcion1 = "Cubismo",
                    opcion2 = "Impresionismo",
                    opcion3 = "Surrealismo",
                    opcion4 = "Barroco",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Quién pintó 'El Guernica'?",
                    opcion1 = "Pablo Picasso",
                    opcion2 = "Diego Rivera",
                    opcion3 = "Frida Kahlo",
                    opcion4 = "Joan Miró",
                    respuestaCorrecta = 0
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué artista es conocido por sus pinturas de nenúfares?",
                    opcion1 = "Vincent van Gogh",
                    opcion2 = "Claude Monet",
                    opcion3 = "Edgar Degas",
                    opcion4 = "Pierre-Auguste Renoir",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué movimiento artístico surgió en el siglo XX como reacción al impresionismo?",
                    opcion1 = "Renacimiento",
                    opcion2 = "Expresionismo",
                    opcion3 = "Barroco",
                    opcion4 = "Rococó",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué artista pintó 'La última cena'?",
                    opcion1 = "Miguel Ángel",
                    opcion2 = "Leonardo da Vinci",
                    opcion3 = "Rafael",
                    opcion4 = "Caravaggio",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué escultura representa a una mujer alada?",
                    opcion1 = "El Pensador",
                    opcion2 = "Venus de Milo",
                    opcion3 = "Victoria alada de Samotracia",
                    opcion4 = "David",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Arte",
                    texto = "¿Qué pintor mexicano es famoso por sus murales?",
                    opcion1 = "Frida Kahlo",
                    opcion2 = "Diego Rivera",
                    opcion3 = "José Clemente Orozco",
                    opcion4 = "David Alfaro Siqueiros",
                    respuestaCorrecta = 1
                ),

                // HISTORIA (15 preguntas)
                Pregunta(
                    categoria = "Historia",
                    texto = "¿En qué año comenzó la Segunda Guerra Mundial?",
                    opcion1 = "1939",
                    opcion2 = "1941",
                    opcion3 = "1945",
                    opcion4 = "1914",
                    respuestaCorrecta = 0
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Quién fue el primer presidente de Estados Unidos?",
                    opcion1 = "Thomas Jefferson",
                    opcion2 = "Abraham Lincoln",
                    opcion3 = "George Washington",
                    opcion4 = "John Adams",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Qué civilización construyó las pirámides de Giza?",
                    opcion1 = "Griegos",
                    opcion2 = "Romanos",
                    opcion3 = "Egipcios",
                    opcion4 = "Mayas",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿En qué año llegó Colón a América?",
                    opcion1 = "1492",
                    opcion2 = "1521",
                    opcion3 = "1607",
                    opcion4 = "1776",
                    respuestaCorrecta = 0
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Qué imperio dominó la mayor parte de Sudamérica antes de los españoles?",
                    opcion1 = "Azteca",
                    opcion2 = "Maya",
                    opcion3 = "Inca",
                    opcion4 = "Olmecca",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿En qué siglo se descubrió la penicilina?",
                    opcion1 = "XVIII",
                    opcion2 = "XIX",
                    opcion3 = "XX",
                    opcion4 = "XXI",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Qué país construyó el Muro de Berlín?",
                    opcion1 = "Estados Unidos",
                    opcion2 = "Unión Soviética",
                    opcion3 = "Alemania Oriental",
                    opcion4 = "Alemania Occidental",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Quién fue el líder de la Revolución Rusa de 1917?",
                    opcion1 = "Joseph Stalin",
                    opcion2 = "Vladimir Lenin",
                    opcion3 = "Leon Trotsky",
                    opcion4 = "Mikhail Gorbachev",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿En qué año terminó la Primera Guerra Mundial?",
                    opcion1 = "1914",
                    opcion2 = "1918",
                    opcion3 = "1923",
                    opcion4 = "1939",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Qué antigua civilización inventó la democracia?",
                    opcion1 = "Romanos",
                    opcion2 = "Egipcios",
                    opcion3 = "Griegos",
                    opcion4 = "Persas",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Quién fue el primer hombre en pisar la Luna?",
                    opcion1 = "Yuri Gagarin",
                    opcion2 = "Neil Armstrong",
                    opcion3 = "Buzz Aldrin",
                    opcion4 = "John Glenn",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿En qué año cayó el Muro de Berlín?",
                    opcion1 = "1985",
                    opcion2 = "1989",
                    opcion3 = "1991",
                    opcion4 = "1975",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Qué emperador romano convirtió al cristianismo en religión oficial?",
                    opcion1 = "Julio César",
                    opcion2 = "Augusto",
                    opcion3 = "Constantino",
                    opcion4 = "Nerón",
                    respuestaCorrecta = 2
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿Qué civilización antigua desarrolló el sistema de escritura cuneiforme?",
                    opcion1 = "Egipcios",
                    opcion2 = "Sumerios",
                    opcion3 = "Griegos",
                    opcion4 = "Fenicios",
                    respuestaCorrecta = 1
                ),
                Pregunta(
                    categoria = "Historia",
                    texto = "¿En qué año se firmó la Declaración de Independencia de Estados Unidos?",
                    opcion1 = "1776",
                    opcion2 = "1789",
                    opcion3 = "1801",
                    opcion4 = "1750",
                    respuestaCorrecta = 0
                )
            )
            db.preguntaDao().insertAll(preguntas)
        }
    }
}