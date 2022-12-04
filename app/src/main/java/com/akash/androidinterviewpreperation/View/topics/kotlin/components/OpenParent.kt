package com.akash.androidinterviewpreperation.View.topics.kotlin.components


// it allows others to inherit from it. By default, a class cannot be inherited in Kotlin.
open class OpenParent {

    // can not override because by default it is final
    fun nonOverridableFunction(){

    }

    open fun overridableFunction(){

    }


}