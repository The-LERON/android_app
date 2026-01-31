package com.example.android_app_1_Hisomov_Tabolin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Объявляем переменные для доступа к элементам интерфейса
    private lateinit var diceImageView: ImageView
    private lateinit var rollButton: Button

    // Массив с ресурсами изображений кубиков - ИСПРАВЛЕНО!
    // Используем подчеркивания вместо дефисов
    private val diceImageArray = arrayOf(
        R.drawable.dice_1,  // dice_1.png - с подчеркиванием!
        R.drawable.dice_2,  // dice_2.png
        R.drawable.dice_3,  // dice_3.png
        R.drawable.dice_4,  // dice_4.png
        R.drawable.dice_5,  // dice_5.png
        R.drawable.dice_6   // dice_6.png
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Настройка отступов под системные панели
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Инициализация элементов интерфейса
        diceImageView = findViewById(R.id.imageView)
        rollButton = findViewById(R.id.button)

        // Устанавливаем начальное изображение (кубик 1)
        diceImageView.setImageResource(diceImageArray[0])

        // Обработчик нажатия на кнопку
        rollButton.setOnClickListener {
            // Генерируем случайное число от 0 до 5 (индексы массива)
            val randomIndex = (0 until diceImageArray.size).random()

            // Устанавливаем соответствующее изображение
            diceImageView.setImageResource(diceImageArray[randomIndex])
        }
    }
}