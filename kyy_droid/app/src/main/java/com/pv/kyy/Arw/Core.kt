package com.pv.kyy.Arw

import android.util.Log
import android.view.View
import arrow.core.*

typealias DefaultMath = Either<String, Int>
typealias DefaultNumber = Option<Int>

typealias DataView = Option<View>

fun Option<Int>.addThree() {
    this.map { it + 3 }
}

sealed class UnderWaterCreature {
    object NotAFish : UnderWaterCreature()
    open class Fish(val id: Int) : UnderWaterCreature()
}

class CatFish : UnderWaterCreature.Fish(1)

class Core {

    infix fun Int.and(a: Int) = this + a

    private fun willBe(s: String): Either<UnderWaterCreature.NotAFish, UnderWaterCreature.Fish> {
        return if (s == "CatFish") Either.Right(UnderWaterCreature.Fish(1121))
        else Either.left(UnderWaterCreature.NotAFish)
    }

    fun Int.addOne() = this + 1

    fun tes() {

        val a = 1 and 2
        val b = willBe("CatFish")

        Log.d("pv", "b before map : $b")
        b.map { it.id }
        Log.d("pv", "b after map : $b")

        val ei: Either<Boolean, Int> = true.left()

        ei.map { it + 5 }.also {
            Log.d("pv", "Down here $it")
        }

//        val defaultMath: Either<String, Int> = 5.right()
        val defaultMath: DefaultMath = "This is not math".left()
        val eiPlusOne = defaultMath.map { it.addOne() }
        Log.d("pv", "defaultMath : $eiPlusOne")

        val nu: DefaultNumber = 5.some()

        Log.d("pv", "nu : $nu")
        val nuPlusThree = nu.map { it + 3 }
        Log.d("pv", "nuPlusThree : $nuPlusThree")
    }
}