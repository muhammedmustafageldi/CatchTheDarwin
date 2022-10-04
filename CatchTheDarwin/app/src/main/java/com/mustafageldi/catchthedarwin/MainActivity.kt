package com.mustafageldi.catchthedarwin

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var handler : Handler = Handler(Looper.getMainLooper())
    private var runnable : Runnable = Runnable{}

    private var score =0
    private var time = 15
    private var imageList = ArrayList<ImageView>()
    private lateinit var scoreText : TextView
    private lateinit var timeText : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreText = findViewById(R.id.scoreText)
        timeText = findViewById(R.id.timeText)


        //Image Array ------->>>>>
        imageList.add(imageView1)
        imageList.add(imageView2)
        imageList.add(imageView3)
        imageList.add(imageView4)
        imageList.add(imageView5)
        imageList.add(imageView6)
        imageList.add(imageView7)
        imageList.add(imageView8)
        imageList.add(imageView9)

        //Hide Image
        val intent = intent
        val difficultLevel = intent.getIntExtra("difficultyLevel",0)
        println(difficultLevel.toLong())
        hideImage(imageList,difficultLevel.toLong())


        object : CountDownTimer(16000,1000){
            override fun onTick(p0: Long) {
                time -= 1
                timeText.text = "Time: ${time}"

                if (p0 in 2501..3199){
                    val mediaPlayer = MediaPlayer.create(this@MainActivity,R.raw.countdown)
                    mediaPlayer.start()
                }

            }

            override fun onFinish() {
                timeText.text = "Time up"

                handler.removeCallbacks(runnable)

                //Game Over
                val intent = Intent(this@MainActivity,GameOverActivity :: class.java)
                intent.putExtra("score",score)
                finish()
                startActivity(intent)
            }

        }.start()


    }

    fun increaseScore (view : View){
        score ++
        scoreText.text = "Score: $score"
        val mediaPlayer = MediaPlayer.create(this@MainActivity,R.raw.sound)
        mediaPlayer.start()
    }

    private fun hideImage (imageList : ArrayList<ImageView>, difficultLevel : Long){

        runnable = Runnable {
            for (element in imageList){
            element.visibility = View.INVISIBLE
            }

            val random = Random()
            val randomIx = random.nextInt(9)
            imageList[randomIx].visibility = View.VISIBLE

            handler.postDelayed(runnable,difficultLevel)
        }

        handler.post(runnable)
    }




}