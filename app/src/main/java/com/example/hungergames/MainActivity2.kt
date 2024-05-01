package com.example.hungergames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity2 : AppCompatActivity() {


    // Creating object to call the methods and variables in the class
    val life = GiveLife()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


//Initialised
        life.playButton = findViewById(R.id.play)
        life.cleanButton = findViewById(R.id.clean)
        life.feedButton = findViewById(R.id.feed)
        life.mainImage = findViewById(R.id.mainImage)

        life.playPercentage = findViewById(R.id.healthPercentage)
        life.cleanPercentage = findViewById(R.id.cleanPercentage)
        life.feedPercentage = findViewById(R.id.hungerPercentage)

        life.playEmoji = findViewById(R.id.healthEmoji)
        life.feedEmoji = findViewById(R.id.hungerEmoji)
        life.cleanEmoji = findViewById(R.id.cleanEmoji)

//Starting sound,Images and Emoji
        life.loadImage(this, "excited_monkey", life.mainImage)
        life.emojiChange(this, life.numberPlay, life.playEmoji)
        life.emojiChange(this, life.numberClean, life.cleanEmoji)
        life.emojiChange(this, life.numberFeed, life.feedEmoji)
        life.playSound(this)

        life.playPercentage.text = "${life.numberPlay}%"
        life.cleanPercentage.text = "${life.numberClean}%"
        life.feedPercentage.text = "${life.numberFeed}%"

//Buttons to change Images,Sounds and Emoji


        life.playButton.setOnClickListener {

            life.playsound(this, "laugh")
//changing the percentage
            life.actions("Play")
//Changing Emoji
            life.emojiChange(this, life.numberPlay, life.playEmoji)
            life.emojiChange(this, life.numberClean, life.cleanEmoji)
            life.emojiChange(this, life.numberFeed, life.feedEmoji)
//Geting random Image
            life.randomImage(this, life.listPlay)

        }

        life.cleanButton.setOnClickListener {

            life.playsound(this, "water")
//changing the percentage
            life.actions("Clean")
//Changing Emoji
            life.emojiChange(this, life.numberPlay, life.playEmoji)
            life.emojiChange(this, life.numberClean, life.cleanEmoji)
            life.emojiChange(this, life.numberFeed, life.feedEmoji)
//Geting random Image
            life.randomImage(this, life.listClean)

        }

        life.feedButton.setOnClickListener {

            life.playsound(this, "eating")
//changing the percentage
            life.actions("Feed")
//Changing Emoji
            life.emojiChange(this, life.numberPlay, life.playEmoji)
            life.emojiChange(this, life.numberClean, life.cleanEmoji)
            life.emojiChange(this, life.numberFeed, life.feedEmoji)
//Geting random Image
            life.randomImage(this, life.listFeed)
        }
    }
}