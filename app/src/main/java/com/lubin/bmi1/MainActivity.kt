package com.lubin.bmi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
//import android.widget.Toast
import com.lubin.bmi1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    val game=NumberGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun guess(view: View){//This is a wrong answer in logcat after I run it.So I'll try again.
        val num=binding.edInput.text.toString().toInt()
        val state=game.guess(num)
        val message=when(state){//enum列舉
            NumberGame.GameState.BIGGER->getString(R.string.bigger)//往strings.xml去找
            NumberGame.GameState.SMALLER->getString(R.string.smaller)
            NumberGame.GameState.BINGO->getString(R.string.bingo)
            else->getString(R.string.something_goes_wrong)
        }
    }

    private fun UpdateUI(message: String) {
        AlertDialog.Builder(this)
            .setTitle(resources.getString(R.string.dialog_title))
            //.setTitle("Guess")
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { d, w ->
                if (game.end) game.reset()
                updateUI()
            //binding.tvCounter.text = game.counter.toString()
            }
            .show()
        updateUI()
    }
    private fun updateUI() {
        binding.tvCounter.text = getString(R.string.counter_, game.counter)
    }
}