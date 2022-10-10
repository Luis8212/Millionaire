package com.example.millionaire

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

// declaring the attributes
lateinit var tv7 : TextView
lateinit var btn7 : Button
lateinit var rgroup7 : RadioGroup

class MainActivity7 : AppCompatActivity() {

    // declare the variable to get the amount from the lasts activities
    var currEarning7 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        //getting the ids from the xml files
        tv7 = findViewById(R.id.textView1)
        btn7 = findViewById(R.id.button)
        rgroup7 = findViewById(R.id.answers7)

        // getting the total from the last activity
        currEarning7 = intent.getIntExtra("earning6", 0)

        // checking to change the background color which button is clicked. then
        // setting up the others as white
        rgroup7.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup7.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup7.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup7.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup7.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }

        }
        )
        // listener for the button
        btn7.setOnClickListener {checkanswer7()}

    }

    // function for the button
    fun checkanswer7() {
        // checking the radio button id to give it an amount
        val answer7 = when (rgroup7.checkedRadioButtonId) {
            R.id.radioButton3 -> 100
            else -> 0

        }
        // giving a message to the user for the amount they earned
        Toast.makeText(this,"You have earned: $answer7", Toast.LENGTH_LONG).show()

        // intent to go to the next activity
        val intnt = Intent(this, MainActivity8::class.java)

        // storing the total in a new variable
        var total = answer7 + currEarning7

        // setting the text with the total to the text view
        tv7.setText("You Earned: $ " + total)

        // going to the next activity
         intnt.putExtra("earning7", total)

        // going to the next activity
         startActivity(intnt)

    }

}