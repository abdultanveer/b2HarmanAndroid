package com.abdul.b2harmanandroid.data

interface Sayable{
    fun say(quote : String): String
}

class MySayable:Sayable {
    override fun say(quote: String): String {
        return "welcome mr --"+quote
    }
}

fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x                                          // 2

fun main() {
    val func = operation()                                          // 3
    println(func(2))                                                // 4
    val upperCase1: (String) -> String = { str: String -> str.uppercase() }
     var mySayable = MySayable()
    println(mySayable.say("abdul"))


                //(String) -> String = {str: String -> "hello from harman mr"+str}
    //println(myQuote)

}