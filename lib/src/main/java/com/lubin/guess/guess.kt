package com.lubin.guess

import kotlin.random.Random

fun guess() {
    val secret = Random.nextInt(10)+1
    println(secret)
    var number=0
    while(secret!=number){
        println("Please input your number 1-10 :")
        number=readLine()!!.toInt()
        if(secret>number)println("bigger")
        else if(secret<number)println("smaller")
        else println("You got it!The secret answer is : $secret")
    }
}