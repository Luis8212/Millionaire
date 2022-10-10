package com.example.millionaire

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

// declaring the attributes
lateinit var tv8 : TextView
lateinit var btn8 : Button
lateinit var rgroup8 : RadioGroup

class MainActivity8 : AppCompatActivity() {

    // declare the variable to get the amount from the lasts activities
    var currEarning8 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        //getting the ids from the xml files
        tv8 = findViewById(R.id.textView1)
        btn8 = findViewById(R.id.button)
        rgroup8 = findViewById(R.id.answers8)

        // getting the total from the last activity
        currEarning8 = intent.getIntExtra("earning7", 0)

        // checking to change the background color which button is clicked. then
        // setting up the others as white
        rgroup8.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup8.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup8.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup8.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup8.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }

        }
        )

        // listener for the button
        btn8.setOnClickListener {checkanswer8()}

    }

    // function for the button
    fun checkanswer8() {
        // checking the radio button id to give it an amount
        val answer8 = when (rgroup8.checkedRadioButtonId) {
            R.id.radioButton2 -> 100
            else -> 0

        }
        // giving a message to the user for the amount they earned
        Toast.makeText(this,"You have earned: $answer8", Toast.LENGTH_LONG).show()

        // intent to go to the next activity
        //val intnt = Intent(this, ThankYou::class.java)

        // storing the total in a new variable
        var total = answer8 + currEarning8

        // setting the text with the total to the text view
        tv8.setText("You Earned: $ " + total)

        // going to the next activity
        // intnt.putExtra("earning8", total)

        // going to the next activity
        // startActivity(intnt)

    }

}