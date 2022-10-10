package com.example.millionaire

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.*

// declare attributes
lateinit var tv3 : TextView
lateinit var btn3 : Button
lateinit var rgroup3 : RadioGroup

class MainActivity3 : AppCompatActivity() {

    // declare the variable to get the amount from the lasts activities
    var currEarning3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // getting the ids from the xml file
        tv3 = findViewById(R.id.textView1)
        btn3 = findViewById(R.id.button)
        rgroup3 = findViewById(R.id.answers3)

        // getting the total from the last activity
        currEarning3=intent.getIntExtra("earning", 0)

        //
        rgroup3.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup3.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup3.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup3.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup3.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }


        }
        )
        btn3.setOnClickListener {checkanswer2()}

    }

    fun checkanswer2() {
        val answer2 = when (rgroup3.checkedRadioButtonId) {
            R.id.radioButton3 -> 300
            else -> 0

        }

        Toast.makeText(this,"You have earned: $answer2", Toast.LENGTH_LONG).show()
        var total = answer2+currEarning3
        tv3.setText("You Earned: $ " + total)
        val intnt3 = Intent(this, MainActivity4::class.java)
        intnt3.putExtra("earning3", total)
        startActivity(intnt3)

    }

}