package com.mustafageldi.catchthedarwin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {

    private lateinit var scoreText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        scoreText = findViewById(R.id.scoreTextEnd)

        //get Intent
        val intent = intent
        val score = intent.getIntExtra("score",0)
        scoreText.text = "Score: $score"
    }

    fun playAgain(view : View){
        val intent = Intent(this@GameOverActivity,MainActivity :: class.java)
        startActivity(intent)
        finish()
    }


}