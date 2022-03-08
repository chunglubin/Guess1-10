package com.lubin.bmi1

import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.AlertDialog

class NumberGame {
    enum class GameState {//遊戲狀態
        INIT, BIGGER, SMALLER, BINGO, END
    }

    var secret: Int = 0
    var counter = 0
    var end = false

    init {//初始化重設類別
        reset()
    }

    fun reset() {
        secret = (1..10).random()
        counter = 0
        end = false
    }

    fun guess(number: Int): GameState {
        counter++
        val message = if (secret > number) GameState.BIGGER
        //val message=if(secret>number)Resources.getSystem().getString(R.string.app_name)
        else if (secret < number) GameState.SMALLER
        else {
            end = true
            GameState.BINGO
            //"Yeah!You got it."
        }
        return message
    }
}