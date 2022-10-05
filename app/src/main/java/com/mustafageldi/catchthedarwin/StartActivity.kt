package com.mustafageldi.catchthedarwin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun startGame(view : View){

        val alert = AlertDialog.Builder(this@StartActivity)
        alert.setTitle("Difficulty level")
        alert.setMessage("Which difficulty level should be set?")
        alert.setIcon(R.drawable.speedometer)

        alert.setPositiveButton("Easy") {dialog , which->
            val intent = Intent(this@StartActivity,MainActivity :: class.java)
            intent.putExtra("difficultyLevel",550)
            startActivity(intent)
            finish()
        }

        alert.setNegativeButton("Hardly") {dialog , which ->
            val intent = Intent(this@StartActivity,MainActivity :: class.java)
            intent.putExtra("difficultyLevel",420)
            startActivity(intent)
            finish()
        }.show()

    }



}