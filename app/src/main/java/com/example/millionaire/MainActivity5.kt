package com.example.millionaire

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

// declare attributes

lateinit var tv5 : TextView
lateinit var btn5 : Button
lateinit var rgroup5 : RadioGroup

class MainActivity5 : AppCompatActivity() {

    // declare the variable to get the amount from the lasts activities
    var currEarning5 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        //getting the ids from the xml files
        tv5 = findViewById(R.id.textView1)
        btn5 = findViewById(R.id.button)
        rgroup5 = findViewById(R.id.answers5)

        // getting the total from the last activity
        currEarning5 = intent.getIntExtra("earning4", 0)

        // checking to change the background color which button is clicked. then
        // setting up the others as white
        rgroup5.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup5.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup5.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup5.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup5.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }

        }
        )
        // listener for the button
        btn5.setOnClickListener {checkanswer5()}

    }

    // function for the button
    fun checkanswer5() {
        // checking the radio button id to give it an amount
        val answer5 = when (rgroup5.checkedRadioButtonId) {
            R.id.radioButton2 -> 300
            else -> 0

        }
        // giving a message to the user for the amount they earned
        Toast.makeText(this,"You have earned: $answer5", Toast.LENGTH_LONG).show()

        // intent to go to the next activity
        val intnt = Intent(this, MainActivity6::class.java)

        // storing the total in a new variable
        var total = answer5 + currEarning5

        // setting the text with the total to the text view
        tv5.setText("You Earned: $ " + total)

        // going to the next activity
        intnt.putExtra("earning5", total)

        // going to the next activity
        startActivity(intnt)

    }

}
