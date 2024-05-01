package com.example.hungergames

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    lateinit var startButton: Button

    fun playSound() {
        // Code to play the sound
        mediaPlayer = MediaPlayer.create(this, R.raw.freak) // Replace "your_sound_file" with the name of your sound file

        mediaPlayer.isLooping = true

        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed to free up resources
        mediaPlayer.release()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Play sound as app starts
        playSound()

        startButton = findViewById(R.id.start)

        startButton.setOnClickListener {
            println("Pressed")
            mediaPlayer.release()
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }



    }
}