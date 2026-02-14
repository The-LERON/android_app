package com.example.android_app_1_Hisomov_Tabolin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var diceImageView: ImageView
    private lateinit var rollButton: Button

    private val diceImageArray = arrayOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        diceImageView = findViewById(R.id.imageView)
        rollButton = findViewById(R.id.button)

        diceImageView.setImageResource(diceImageArray[0])

        rollButton.setOnClickListener {
            val randomIndex = (0 until diceImageArray.size).random()
            diceImageView.setImageResource(diceImageArray[randomIndex])
        }
    }
}