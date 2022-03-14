package com.lubin.bmi1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel:ViewModel() {
    private var secret=0
    val counter=MutableLiveData<Int>()//external class
    enum class GameState {//遊戲狀態
    INIT, BIGGER, SMALLER, BINGO, END
    }
    val gameState=MutableLiveData<GameState>()//external class
    init {
        gameState.value=GameState.INIT
        secret=(1..10).random()
        counter.value=0
        println("secret:$secret")
    }
    fun guess(num:Int){
        counter.value=counter.value?.plus(1)
        gameState.value=if(num>secret) GameState.SMALLER
        else if (num<secret)GameState.SMALLER
        else GameState.BINGO
    }
    fun reset(){
        counter.value=0
    }
}