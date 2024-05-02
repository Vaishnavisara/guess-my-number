package com.rcd.guessmynumber

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    var next: Button? = null
    var yes:Button?=null
    var no:Button?=null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next = findViewById(R.id.button1)
        yes=findViewById(R.id.yes)
        no=findViewById(R.id.no)
        var img = findViewById<ImageView>(R.id.img)
        img.setImageResource(R.drawable.guess)

    }

    fun secondLayout(view: View){
        setContentView(R.layout.activity_main2)
        var userGuess = findViewById<EditText>(R.id.input)
        var hint = findViewById<TextView>(R.id.output)
        var guess=findViewById<TextView>(R.id.guess)
        var guesses = 5
        var number: Int = Random.nextInt(0, 20)



        var button2  = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
//        guess.text="guesses : $guesses"
        var n = userGuess.text.toString()
        var num = n.toInt()
        if (number == num) {
           setContentView(R.layout.activity_main3)


        } else if (number < num) {
            hint?.text = "too high"
            guesses--
            guess.text="guesses : $guesses"
            userGuess.text = null
        } else {
            hint?.text = "too low"
            guesses--
            guess.text="guesses : $guesses"
            userGuess.text = null
        }
        if(guesses==0){
            setContentView(R.layout.activity_main4)
        }
    }

    }
    fun yes(view: View) {
        secondLayout(view)
    }
    fun no(view: View){
        setContentView(R.layout.activity_main)
    }
}






