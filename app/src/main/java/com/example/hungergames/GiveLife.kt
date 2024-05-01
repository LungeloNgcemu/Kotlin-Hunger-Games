package com.example.hungergames

import android.content.Context
import android.media.MediaPlayer
import android.widget.Button
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView
import kotlin.random.Random


class GiveLife {
//Buttons
    lateinit var playButton: Button
    lateinit var feedButton: Button
    lateinit var cleanButton: Button
//Display percentage
    lateinit var playPercentage: TextView
    lateinit var feedPercentage: TextView
    lateinit var cleanPercentage: TextView

//Emoji view
    lateinit var playEmoji: GifImageView
    lateinit var feedEmoji: GifImageView
    lateinit var cleanEmoji: GifImageView
//Main image view
    lateinit var mainImage: GifImageView


    var number: Int = 0
    var numberPlay: Int = 50
    var numberFeed: Int = 50
    var numberClean: Int = 50

 //   Media player
    private lateinit var mediaPlayer: MediaPlayer


    //Images
    var listClean = listOf("monkey_bath_1", "monkey_bath_2", "monkey_bath_4")
    var listPlay = listOf("monkey_play_1", "monkey_play_2", "monkey_play_3")
    var listFeed = listOf("monkey_eat_1", "monkey_eat_2", "monkey_eat_3")
    var listEmoji = listOf("crying", "dead", "great", "happy", "sad")

    //Sounds
    var listSound = listOf("water", "eating", "laugh")
    var listRandom = mutableListOf("8")

//Load image to the viewa
    fun loadImage(context: Context, drawableName: String, viewName: GifImageView) {
        val resourceId =
            context.resources.getIdentifier(drawableName, "drawable", context.packageName)
        viewName.setImageResource(resourceId)

    }
    //Site: ChatGpt
    //URL: https://chat.openai.com/



// Emoji reaction to percentage
    fun emojiChange(context:Context, amount:Int,view: GifImageView){

        if(amount >= 100 ){

            loadImage(context,"sick",view)

        }else if (amount < 100  && amount >= 80){

            loadImage(context,"great",view)

        }else if (amount < 80 && amount >=60 ){

            loadImage(context,"happy",view)

        }
        else if (amount < 60 && amount >=40 ){

            loadImage(context,"sad",view)

        }
        else if (amount < 40 && amount >=20 ){

            loadImage(context,"crying",view)

        } else if (amount < 20 && amount > 0 ){

            loadImage(context,"dead",view)

        }else if(amount <= 0  ){
            loadImage(context,"bone",view)
        }

    }


    //Generate random images and makes sure there are no duplicate images
    fun randomImage(context:Context, list: List<String>) {

        number = Random.nextInt(0, 3)

        while (listRandom.last().toInt() == number) {

            number = Random.nextInt(0, 3)
        }



        if (listRandom.last().toInt() != number) {
            println(number)
            val item = list[number]
            loadImage(context, item, mainImage)

            listRandom.add(number.toString())
        }

    }


    //play sound by selection
    fun playsound(context: Context, rawName: String) {
        mediaPlayer?.release()
        val resourceId = context.resources.getIdentifier(rawName, "raw", context.packageName)

        mediaPlayer = MediaPlayer.create(
            context,
            resourceId
        )
        mediaPlayer.start()
    }




    // Play starting sound
    fun playSound(context: Context) {
        mediaPlayer = MediaPlayer.create(
            context,
            R.raw.screen_sound
        )
        mediaPlayer.start()
    }
    //Site: ChatGpt
    //URL: https://chat.openai.com/

//The reactions to pressing the button subtracts and adds
    fun actions(selectedOption: String) {
        when (selectedOption) {
            "Play" -> {

                numberPlay += 5
                numberClean -= 5


                playPercentage.text = "${numberPlay}%"
                cleanPercentage.text = "${numberClean}%"
                feedPercentage.text = "${numberFeed}%"


            }

            "Clean" -> {
                numberClean += 5
                numberFeed -= 5

                playPercentage.text = "${numberPlay}%"
                cleanPercentage.text = "${numberClean}%"
                feedPercentage.text = "${numberFeed}%"

            }

            "Feed" -> {
                numberFeed += 5
                numberPlay -= 5

                playPercentage.text = "${numberPlay}%"
                cleanPercentage.text = "${numberClean}%"
                feedPercentage.text = "${numberFeed}%"

            }

            else -> {
                // Default case when selectedOption doesn't match any of the specified options
            }
        }
    }

}