package com.lubin.bmi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
//import android.widget.Toast
import com.lubin.bmi1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun guess(view: View){//This is a wrong answer in logcat after I run it.So I'll try again.
        var secret=Random.nextInt(10)+1
        secret=binding.edGuess.text.toString().toInt()
        val number=binding.edNumber.text.toString().toInt()
        while(secret!=number){
            if(secret>number)println("bigger")
            else if(secret<number)println("smaller")
            else Log.d("You win!",number.toString())

        }
        println("The secret is: $secret")
        println("The number is; $number")
        Log.d("You win!",number.toString())

    }
}