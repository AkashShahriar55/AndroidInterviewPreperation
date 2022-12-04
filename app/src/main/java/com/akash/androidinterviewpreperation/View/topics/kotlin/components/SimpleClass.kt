package com.akash.androidinterviewpreperation.View.topics.kotlin.components


/**
 * public constructor cannot have a function body
 * data - is only accesable in init block ( init block scope )
 * name - it is a val  ( class scope )
 */
class SimpleClass( data:String , val name:String) {


    //`init` is the initialiser block in Kotlin.
    // It's executed once the primary constructor is instantiated.
    // If you invoke a secondary constructor,
    // then it works after the primary one as it is composed in the chain.
    init {
        println("Simple class is constructed first init block")
    }

    init {
        println("second init block")
    }



     var otherData:Int = 0


    // first invoke the primary constructor then execute secondary
    constructor(data:String,name: String,otherData:Int):this(data,name){
        this.otherData = otherData
        println("Secondary constructor has build")
    }

    fun simpleFunction(){

    }
}