package com.example.millionaire

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

// declare attributes

lateinit var tv4 : TextView
lateinit var btn4 : Button
lateinit var rgroup4 : RadioGroup

class MainActivity4 : AppCompatActivity() {

    // declare the variable to get the amount from the lasts activities
    var currEarning4 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //getting the ids from the xml files
        tv4 = findViewById(R.id.textView1)
        btn4 = findViewById(R.id.button)
        rgroup4 = findViewById(R.id.answers4)

        // getting the total from the last activity
        currEarning4 = intent.getIntExtra("earning3", 0)

        // checking to change the background color which button is clicked. then
        // setting up the others as white
        rgroup4.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener(){ radioGroup: RadioGroup, i: Int ->
            if (rgroup4.checkedRadioButtonId == R.id.radioButton3) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.RED)

            }
            if (rgroup4.checkedRadioButtonId == R.id.radioButton2) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.RED)
            }

            if (rgroup4.checkedRadioButtonId == R.id.radioButton) {
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.RED)
            }

            if (rgroup4.checkedRadioButtonId == R.id.radioButton4) {
                findViewById<RadioButton>(R.id.radioButton).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton2).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton3).setBackgroundColor(Color.WHITE)
                findViewById<RadioButton>(R.id.radioButton4).setBackgroundColor(Color.RED)
            }

        }
        )
        // listener for the button
        btn4.setOnClickListener {checkanswer4()}

    }

    // function for the button
    fun checkanswer4() {
        // checking the radio button id to give it an amount
        val answer4 = when (rgroup4.checkedRadioButtonId) {
            R.id.radioButton4 -> 500
            else -> 0

        }
        // giving a message to the user for the amount they earned
        Toast.makeText(this,"You have earned: $answer4", Toast.LENGTH_LONG).show()

        // intent to go to the next activity
        val intnt = Intent(this, MainActivity5::class.java)

        // storing the total in a new variable
        var total = answer4 + currEarning4

        // setting the text with the total to the text view
        tv4.setText("You Earned: $ " + total)

        // going to the next activity
        intnt.putExtra("earning4", total)

        // going to the next activity
        startActivity(intnt)
    }

}