package com.lubin.bmi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.lubin.bmi1.NumberGame.*
//import android.widget.Toast
import com.lubin.bmi1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    //val game=NumberGame()
    val viewModel by viewModels<GuessViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.counter.observe(this) {
            binding.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(this) { state ->
            val message = when (state) {//enum列舉
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)//往strings.xml去找
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "Start!"
                else -> getString(R.string.something_goes_wrong)
            }
            AlertDialog.Builder(this)
                .setTitle(resources.getString(R.string.dialog_title))
                //.setTitle("Guess")
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { d, w ->
                    if (state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                    //updateUI()
                    //binding.tvCounter.text = game.counter.toString()
                }
                .show()
        }
    }
        //updateUI()
        /*private fun updateUI() {
        binding.tvCounter.text = getString(R.string.counter_, game.counter)
    }*/
    fun guess(view: View) {
        val num = binding.edInput.text.toString().toInt()
        viewModel.guess(num)
    }
}