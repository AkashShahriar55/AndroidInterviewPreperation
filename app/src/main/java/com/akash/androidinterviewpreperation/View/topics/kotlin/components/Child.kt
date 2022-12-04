package com.akash.androidinterviewpreperation.View.topics.kotlin.components



class Child:/*Parent(this will give compiler error)*/ OpenParent() {

    // this function is overridable function
    override fun overridableFunction() {
        super.overridableFunction()
    }

}