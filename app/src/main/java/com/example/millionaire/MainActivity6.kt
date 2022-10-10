package com.example.millionaire

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

// declaring the attributes
lateinit var tv6 : TextView
lateinit var btn6 : Button
lateinit var rgroup6 : RadioGroup

class MainActivity6 : AppCompatActivity() {

    // declare the variable to get the amount from the lasts activities
    var currEarning6 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        //getting the ids from the xml files
        tv6 = findViewById(R.id.textView1)
        btn6 = findViewById(R.id.button)
        rgroup6 = findViewById(R.id.answers6)

        // getting the total from the last activity
        currEarning6 = intent.getIntExtra("earning5", 0)

        // checking to change the background color which button is clicked. then
        // setting up the others as white
        rgroup6.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup6.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup6.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup6.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup6.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }

        }
        )
        // listener for the button
        btn6.setOnClickListener {checkanswer6()}

    }

    // function for the button
    fun checkanswer6() {
        // checking the radio button id to give it an amount
        val answer6 = when (rgroup6.checkedRadioButtonId) {
            R.id.radioButton -> 300
            else -> 0

        }
        // giving a message to the user for the amount they earned
        Toast.makeText(this,"You have earned: $answer6", Toast.LENGTH_LONG).show()

        // intent to go to the next activity
        val intnt = Intent(this, MainActivity7::class.java)

        // storing the total in a new variable
        var total = answer6 + currEarning6

        // setting the text with the total to the text view
        tv6.setText("You Earned: $ " + total)

        // going to the next activity
        intnt.putExtra("earning6", total)

        // going to the next activity
        startActivity(intnt)

    }

}