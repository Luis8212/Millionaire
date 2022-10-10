package com.example.millionaire

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

lateinit var tv2 : TextView
lateinit var btn2 : Button
lateinit var rgroup2 : RadioGroup

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv2 = findViewById(R.id.textView)
        btn2 = findViewById(R.id.button)
        rgroup2 = findViewById(R.id.answers2)

        rgroup2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup2.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup2.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup2.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup2.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }

        }
        )

         btn2.setOnClickListener {checkanswer()}
    }

    fun checkanswer(){
        val answer = when (rgroup2.checkedRadioButtonId){
            R.id.radioButton -> 100
            else -> 0

        }
        tv2.setText("You Earned: $ $answer ")

        Toast.makeText(this,"You have earned: $answer", Toast.LENGTH_LONG).show()
        val intnt = Intent(this, MainActivity3::class.java)
        intnt.putExtra("earning", answer)
        startActivity(intnt)
    }
}