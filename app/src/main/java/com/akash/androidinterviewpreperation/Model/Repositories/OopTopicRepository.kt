package com.akash.androidinterviewpreperation.Model.Repositories


/**
 * The basic concepts of OOPs are:
 *
 * Inheritance - The ability for a class to inherit characteristics
 * and behaviours from another class allows for more code reuse.
 *
 * Encapsulation - Encapsulation is also a part of the OOPs concept.
 * It refers to the bundling of data with the methods that operate on that data.
 * It also helps to restrict any direct access to some of an object’s components.
 *
 * Polymorphism - Polymorphism allows for the creation
 * of several objects from a single, adaptable class of code.
 * It explains the concept of different classes can be used with the same interface.
 * Each of these classes can have its own implementation of the interface.
 *
 * Abstraction - Abstraction is an OOPs concept to build the structure of real-world objects.
 * It “shows” only essential attributes and “hides” unnecessary information from the outside.
 * The main focus of abstraction is to hide unnecessary details from the users.
 * It is one of the most important concepts of OOPs.
 *
 */


/**
 * Static polymorphism
 *
 *
 * static polymorphism determines which method to call at compile time.
 * For the same trigger with static polymorphism, the object might respond differently.
 * Function, constructor and operator overloading are examples of static polymorphism.
 *
 * Dynamic polymorphism
 *
 * Dynamic polymorphism is a method or process that handles a call
 * to an overridden method during runtime rather than at compile time.
 * It is also referred to as dynamic method dispatch or runtime polymorphism.
 * Using method overriding, we can create dynamic polymorphism.
 * An example of runtime polymorphism: is method overriding.
 */

class OopTopicRepository {


    fun method( param1:String){
        println("A simple method")
        println(param1)
    }

    /**
     * There is a concept where two or more methods can have the same name.
     * But they should have different parameters, different numbers of parameters,
     * different types, or both. These methods are known as overloaded methods
     * and this feature is called method overloading.
     *
     * this is a static polymorphism too
     */
    fun method(param1: String,param2: String){
        println("Overloaded method")
        println("$param1 $param2")
    }


    open class parent(){
        open fun method(){
            println("I am a method")
        }
    }

    /**
     * Method overriding is a concept of object-oriented programming.
     * It is a language feature that allows a subclass or child class
     * to provide a specific implementation of a method which is already
     * provided by one of its superclasses or parent classes.
     */
    class derived(): parent() {

        // this is also an example of dynamic polymorphism
        override fun method() {
            println("I am an overloaded method")
        }
    }





}