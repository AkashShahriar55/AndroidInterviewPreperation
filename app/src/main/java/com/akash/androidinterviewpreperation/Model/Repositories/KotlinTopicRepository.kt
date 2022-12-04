package com.akash.androidinterviewpreperation.Model.Repositories

import com.akash.androidinterviewpreperation.View.topics.kotlin.components.FastClass
import java.io.File
import java.io.FileNotFoundException
import javax.sql.DataSource
import kotlin.properties.Delegates


// this is the playground for checking the codes

fun main() {
    println("Let's play")

    val kotlinTopicRepository = KotlinTopicRepository()

    kotlinTopicRepository.playWithEquality()

    kotlinTopicRepository.checkingLazyVariables()


    val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
    items.fold(0) {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

// Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)


    kotlinTopicRepository.playWithNoInlineFunction()



    kotlinTopicRepository.playWithDelegation()
}

/**
 * Null Safety - By default, all sorts of variables in Kotlin are non-nullable
 * Coroutines Support - which halt execution at a given moment without blocking threads while doing long-running demanding operations.
 * Data Classes - the compiler will take care of everything, including constructing constructors, getter, and setter methods for various fields.
 * Functional Programming - language that has numerous useful features such as lambda expressions, operator overloading, higher-order functions, and lazy evaluation, among others.
 * Extension Functions - By prefixing the name of a class to the name of the new function, we can build extended functions.
 * Data Type Inference - We don't have to declare the type of each variable based on the assignment it will handle in Kotlin.
 * Smart Casting - Smart casts in Kotlin will take care of these casting checks with the keyword "is-checks,"
 * Checked Exceptions - We don't have checked exceptions in Kotlin. As a result, developers do not need to declare or catch exceptions, which has both benefits and drawbacks
 */


/**
 * GIST
 *
 * List down the visibility modifiers available in Kotlin. What’s the default visibility modifier?
 * -   public
 * -   internal
 * -   protected
 * -   private
 * `public` is the default visibility modifier.
 *
 *
 *
 */


class KotlinTopicRepository {




    @JvmField
    val name = "I am kotlin Topic Repository and also a Jvm field"

    val tag = "KotlinTopicRepository"


    /**
     * @JvmStatic: The @JvmStatic annotation is used to tell the compiler
     * that the method is a static method, and you can use it in Java code.
     * @JvmOverloads: The @JvmOverloads annotation is required when we need
     * to use the default values passed as an argument in Kotlin code from the Java code.
     * @JvmField: The @JvmField annotation is used to access the fields of a
     * Kotlin class from Java code without any getters and setters.
     * We need to use the @JvmField in the Kotlin code.
     */



    // All the required static member functions and member variables can be kept inside the companion object created.
    companion object{

        // By default val properties are set at runtime. Adding a const modifier on a val would make a compile-time constant.
        val simpleValData = "Simple val data"
        const val constantValData = "Constant val data"



        // this variable can be accessed as static variable from java code
        @JvmStatic
        val jvmStaticValue= "I am a jvm static "

        // this function can be accessed as static function from java code
        @JvmStatic
        fun jvmStaticFunction(){

        }





    }


    // It works only with var
    // It's not thread-safe. In a multi-threaded system
    private lateinit var aLateInitVar:String


    /**lateinit' modifier is not allowed on properties of primitive types*/
    //lateinit var primitive:Int


    private val slowString:String by lazy {
        println("slow string has initialized")
        "Slow String"
    }


    /**
     * Val and var serve a distinct purpose than immutable and mutable lists.
     * The val and var keywords specify how a variable's value/reference should be handled.
     */

    private val mutableList = mutableListOf("This","is","a","mutable") // list value can be changed


    // Because no write access is required in multi-threaded systems,immutable resources cannot induce race conditions.
    // a new state based on it, rather than being altered.
    private var immutableList = listOf("This","is","a","immutable","list") // list value cannot change but the whole list can


    /** We do not need a break statement at the end of each case
     * Inside the when expression, it compares all of the
     * branches one by one until a match is discovered.
     * After finding the first match, it proceeds to the
     * conclusion of the when block and executes the code
     * immediately following the when block
     */

    @JvmOverloads // assigning default value when overloading from a java class
    fun whenBlock(temp:String = "Job"){
        when(temp) {
            "Interview" -> println("Interview Bit is the solution.")
            "Job" -> println("Interview is the solution.")
            "Success" -> println("Hard Work is the solution.")
        }
    }



    // advantages of kotlin
    fun advantages(): String {
        return "<b>Data class</b>: In Java, you must create getters and setters for each object,\n" +
                " as well as properly write hashCode (or allow the IDE to build it for you, \n" +
                "which you must do every time you update the class), toString, and equals. \n" +
                "Alternatively, you could utilize lombok, but that has its own set of issues. \n" +
                "In Kotlin, data classes take care of everything.\n\n" +

                "<b>Patterns of getter and setter</b>: In Java, for each variable, you use it for,\n " +
                "rewrite the getter and setter methods. You don't have to write getter and setter \n" +
                "in kotlin, and if you must, custom getter and setter take a lot less typing. \n" +
                "There are additional delegates for identical getters and setters.\n\n" +

                "<b>Extension Functions</b>: In Java, there is no support for extension functions. \n" +
                "Kotlin on the other hand provides support for extension functions which makes\n " +
                "the code more clear and cleaner.\n" +

                "<b>Support for one common codebase</b>: You may extract one common codebase that will \n" +
                "target all of them at the same time using the Kotlin Multi-Platform framework.\n\n" +

                "<b>Support for Null Safety</b>: Kotlin has built-in null safety support, \n" +
                "which is a lifesaver, especially on Android, which is full of old Java-style APIs.\n\n" +

                "<b>Less prone to errors</b>: There is less space for error because\n " +
                "it is more concise and expressive than Java.\n"

    }


    /**
     *
     */
    fun mutableList(): MutableList<String> {
        mutableList.add("list")
        return mutableList
    }



    fun immutableList(): List<String> {
        //immutableList.add("something") there is no add function
        return immutableList
    }


    fun newImmutableList():List<String>{
        immutableList = listOf("this","is","changed","list")
        return immutableList
    }

    fun newMutableList():MutableList<String>{
        // mutableList = mutableListOf("changed")
        // Val cannot be reassigned
        return mutableList
    }



    fun lateInitVariable(): String {
        if(this::aLateInitVar.isInitialized){
            // the variable is initalized
            return aLateInitVar
        }

        aLateInitVar = "I have initialized"
        return aLateInitVar
    }



    fun checkingLazyVariables(){
        val fastClass = FastClass()
        fastClass.accessSlowClass()
    }





    // What’s the difference between == and === operators in Kotlin?
    private var first = "sky"
    private val second = first
    private val third = String().plus("sky") // if i give sky using literal it will give same instance of first variable




    fun playWithEquality(){

        println(first == second)
        println(first == third)
        println(first === second)
        println(first === third)
        first = "sky"  // it didn't created new string as lateral get string from string pool
        println(first == second)
        println(first === second)

        first = "cloud" // it created new string as the literal may not in the string pool
        println(first == second)
        println(first === second)
    }











    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }


    //Infix function calls have lower precedence than arithmetic operators, type casts, and the rangeTo operator.
    infix fun Int.shl(x: Int): Int {
        return this * x
    }




    fun function(string: String) {
        fun localFunction(size: Int) {
           println(size)
        }

        localFunction(string.length)
    }


    /**
     * A higher-order function is a function that takes functions as parameters,
     *
     * the combine parameter has the function type (R, T) -> R,
     * so it accepts a function that takes two arguments of
     * types R and T and returns a value of type R. It is invoked
     * inside the for loop, and the return value is then assigned to accumulator.
     */
    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }



    // this is a lambda expression
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }


    fun playWithLambdaExpression(){
        val list = listOf(1,2,3,4)
        list.forEach(
            // this is a lambda expression
            { value ->
                println(sum(value,value))

            }
        )
    }


    fun playWithInlineFunction(){
        val list = listOf(1,2,3,4)


        myForEach(list) {
            println(it)
        }


    }


    fun playWithNoInlineFunction(){
        foo({
            println("no inline")
        }){
            println("inline")
        }
    }



    // this is an inline function
    // The inline modifier affects both the function itself and
    // the lambdas passed to it: all of those will be inlined into the call site.
    inline fun <T> myForEach(list :  Iterable<T>,action: (T) -> Unit): Unit {
        for (element in list) action(element)
    }

    // this is an inline function
    inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
        inlined.invoke()
        notInlined.invoke()
    }


    /**
     * Interfaces in Kotlin can contain declarations of abstract methods,
     * as well as method implementations. What makes them different from
     * abstract classes is that interfaces cannot store state.
     * They can have properties, but these need to be abstract or provide accessor implementations.
     */
    interface SampleInterface{
        // interface can't store state or any value;
        //val test = 0;
        val data:Int;
        fun bar()
        fun foo(){
            println(data)
        }
    }






    fun playWithInterface(){
        val callback = object : SampleInterface{
            override val data: Int
                get() = 100

            override fun bar() {
                println(data * 10)
            }

        }

        callback.foo()
        callback.bar()
        println(callback.data)
    }


    /**
     * Sealed classes and interfaces represent restricted class
     * hierarchies that provide more control over inheritance.
     * All direct subclasses of a sealed class are known at compile time.
     * No other subclasses may appear outside a module within
     * which the sealed class is defined. For example,
     * third-party clients can't extend your sealed class in their code.
     * Thus, each instance of a sealed class has a type from a limited
     * set that is known when this class is compiled.
     *
     * In some sense, sealed classes are similar to enum classes:
     * the set of values for an enum type is also restricted,
     * but each enum constant exists only as a single instance,
     * whereas a subclass of a sealed class can have multiple instances,
     * each with its own state.
     *
     * A sealed class is abstract by itself,
     * it cannot be instantiated directly and can have abstract members.
     */

    sealed interface Error

    sealed class IOError(): Error{
        fun something(){

        }
    }

    class FileReadError(val file: File): IOError()
    class DatabaseError(val source: DataSource): IOError()

    object RuntimeError : Error


    fun playWithSealed(data:Error){


        // val error = IOError(); // Cannot access '<init>': it is protected in 'IOError'


        when(data){
            is FileReadError -> println("file reader error")
            is DatabaseError -> println("database error")
            RuntimeError -> println("runtime error")
            // the `else` clause is not required because all the cases are covered
        }
    }


    /**
     * The Delegation pattern has proven to be a good
     * alternative to implementation inheritance, and
     * Kotlin supports it natively requiring zero boilerplate code
     *
     *
     */


    interface Base {
        val message: String
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override val message = "BaseImpl: x = $x"
        override fun print() { println(message) }
    }

    class Derived(b: Base) : Base by b {
        // This property is not accessed from b's implementation of `print`
        override val message = "Message of Derived"
    }



    fun playWithDelegation() {
        val b = BaseImpl(10)
        val derived = Derived(b)
        derived.print()
        println(derived.message)
    }


    class User {
        var name: String by Delegates.observable("<no name>") {
                prop, old, new ->
            println("$old -> $new")
        }
    }

    fun playWithDelegatedProperty() {
        val user = User()
        user.name = "first"
        user.name = "second"
    }


}