package com.akash.androidinterviewpreperation.View.topics.kotlin.components

class FastClass {


    init {
        println("main class is initialized")
    }


    val slowClassIsFast = SlowClass("Fast class")


    //  It works only with val.
    // Thread-safety is enabled by default, ensuring that the initializer is only called once.
    private val slowClass:SlowClass by lazy {
        SlowClass("Slow class")
    }


    fun accessSlowClass(): SlowClass {
        return slowClass
    }
}