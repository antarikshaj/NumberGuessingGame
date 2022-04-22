package com.example.numberguessinggame

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLeft: Button = findViewById(R.id.leftButton)
        val btnRight: Button = findViewById(R.id.rightButton)
        val backgroundView: ConstraintLayout = findViewById(R.id.backgroundView)
         assignRandom(btnLeft, btnRight)

        btnLeft.setOnClickListener {
            if (isLeftGreater(btnLeft, btnRight)) {
                backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Right Answer", Toast.LENGTH_SHORT).show()
            }
            else{
                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
            assignRandom(btnLeft, btnRight)
        }

        btnRight.setOnClickListener {
            if (!isLeftGreater(btnLeft, btnRight)) {
                backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Right Answer", Toast.LENGTH_SHORT).show()
            }
            else{
                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
            assignRandom(btnLeft, btnRight)
        }
    }

    private fun assignRandom(btn1: Button, btn2: Button){
        val random: Random = Random.Default
        btn1.text = random.nextInt(0, 10).toString()
        btn2.text = random.nextInt(0, 10).toString()
    }

    private fun isLeftGreater(btnLeft: Button, btnRight: Button): Boolean {
        val btnLeftVal = btnLeft.text.toString().toInt()
        val btnRightVal = btnRight.text.toString().toInt()
        return btnLeftVal >= btnRightVal
    }


}