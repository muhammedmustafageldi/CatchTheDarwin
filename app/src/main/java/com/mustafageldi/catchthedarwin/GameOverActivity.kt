package com.mustafageldi.catchthedarwin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {

    private lateinit var scoreText : TextView
    private var difficultyLevel = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        scoreText = findViewById(R.id.scoreTextEnd)

        //get Intent
        val intent = intent
        val score = intent.getIntExtra("score",0)
        difficultyLevel = intent.getIntExtra("difficulty",0)
        scoreText.text = "Score: $score"
    }

    fun playAgain(view : View){
        val intent = Intent(this@GameOverActivity,MainActivity :: class.java)
        intent.putExtra("difficultyLevel",difficultyLevel)
        startActivity(intent)
        finish()
    }

    fun goToHomePage(view : View){
        val intent = Intent(this@GameOverActivity,StartActivity :: class.java)
        startActivity(intent)
        finish()
    }


}