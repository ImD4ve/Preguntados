package com.example.preguntados
import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlin.math.floor
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PreguntaViewModel
    private lateinit var wheelView: WheelView
    private lateinit var questionPanel: View
    private lateinit var questionText: TextView
    private lateinit var option1: Button
    private lateinit var option2: Button
    private lateinit var option3: Button
    private lateinit var option4: Button
    private lateinit var livesText: TextView
    private lateinit var spinButton: Button

    private val categories = resources.getStringArray(R.array.categories).toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupViewModel()
        setupObservers()
    }

    private fun initViews() {
        wheelView = findViewById(R.id.wheelView)
        questionPanel = findViewById(R.id.questionPanel)
        questionText = findViewById(R.id.questionText)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        livesText = findViewById(R.id.livesText)
        spinButton = findViewById(R.id.spinButton)

        spinButton.setOnClickListener { spinWheel() }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[PreguntaViewModel::class.java]
    }

    private fun setupObservers() {
        viewModel.lives.observe(this) { lives ->
            livesText.text = getString(R.string.lives_text, lives)
            if (lives <= 0) showGameOver(false)
        }

        viewModel.currentQuestion.observe(this) { question ->
            question?.let { showQuestion(it) }
        }

        viewModel.errorMessage.observe(this) { error ->
            error?.let { showError(it) }
        }
    }

    private fun spinWheel() {
        spinButton.isEnabled = false
        questionPanel.visibility = View.GONE

        val randomRotation = 720 + Random.nextInt(1080)
        ObjectAnimator.ofFloat(wheelView, "rotation", 0f, randomRotation.toFloat()).apply {
            duration = 3000
            interpolator = DecelerateInterpolator()
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    val selectedCategory = getCategoryFromRotation(wheelView.rotation % 360)
                    viewModel.getQuestion(selectedCategory)
                }
                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
            start()
        }
    }

    private fun getCategoryFromRotation(rotation: Float): String {
        val normalizedRotation = if (rotation < 0) rotation + 360 else rotation
        val segment = floor((normalizedRotation / 90).toDouble()).toInt()
        return categories[segment % categories.size]
    }

    private fun showQuestion(pregunta: Pregunta) {
        questionText.text = pregunta.texto
        option1.text = pregunta.opcion1
        option2.text = pregunta.opcion2
        option3.text = pregunta.opcion3
        option4.text = pregunta.opcion4

        option1.setOnClickListener { checkAnswer(0) }
        option2.setOnClickListener { checkAnswer(1) }
        option3.setOnClickListener { checkAnswer(2) }
        option4.setOnClickListener { checkAnswer(3) }

        questionPanel.visibility = View.VISIBLE
        spinButton.isEnabled = true
    }

    private fun checkAnswer(selectedIndex: Int) {
        if (viewModel.checkAnswer(selectedIndex)) {
            Toast.makeText(this, R.string.correct_answer, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.incorrect_answer, Toast.LENGTH_SHORT).show()
        }
        questionPanel.visibility = View.GONE
    }

    private fun showGameOver(isWin: Boolean) {
        AlertDialog.Builder(this)
            .setTitle(if (isWin) getString(R.string.game_over_title_win) else getString(R.string.game_over_title_lose))
            .setMessage(if (isWin) getString(R.string.game_over_message_win) else getString(R.string.game_over_message_lose))
            .setPositiveButton(R.string.restart_button) { _, _ -> viewModel.resetGame() }
            .setNegativeButton(R.string.exit_button) { _, _ -> finish() }
            .setCancelable(false)
            .show()
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        spinButton.isEnabled = true
    }

}
