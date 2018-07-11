package com.pv.kyy.Arw

import android.util.Log
import arrow.core.Either
import arrow.core.Option
import arrow.core.right
import arrow.core.some

typealias Age = Int

object Minor {
    private var string: Option<String> = "".some()

    fun arrowDemoOption() {

        string.map { it.plus("A") }
    }

    fun Option<String>.appendA() = this.map { it.plus("A") }

    fun Option<String>.appendB() = this.map { it.plus("B") }

    fun Option<String>.appendC() = this.map { it.plus("C") }



    private var intString: Either<String, Int> = 1.right()

    fun arrowDemoEither() {

        val addedToEither = intString.addOne()

        addedToEither.fold(
                {
                    Log.d("pv", "String Value : $it")
                },
                {
                    Log.d("pv", "Integer Value : $it")
                }
        )
    }

    fun Either<String, Int>.addOne() = this.map { it + 1 }

    fun ageTest() {

        val age: Age = 10
        val addedAge = age.addFive()
    }

    fun Age.addFive() = this + 5

    fun onStart() {

        val appendedString= string.appendA().appendB().appendC()

        appendedString.fold(
                {
                    Log.d("pv", "Empty String Handling")
                },
                {
                    Log.d("pv", "String Value : $it")
                }
        )
    }
}