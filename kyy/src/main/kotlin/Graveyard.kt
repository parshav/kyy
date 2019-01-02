import Behavior.CoreLife
import java.lang.Exception
import java.math.BigInteger

object Graveyard : CoreLife { // was Core

    override fun onStart() {

        f("")
    }

    fun partlist(arr: Array<String>): Array<Array<String>> {

        var mutableList = mutableListOf<Array<String>>()

        arr.forEachIndexed { i, _ ->
            mutableList.add(i, arrayOf(arr.take(i).joinToString(" "), arr.takeLast(arr.size - i).joinToString(" ")))
        }
        mutableList.removeAt(0)
        return mutableList.toTypedArray()
    }

    fun longest(a: String, b: String): String{
        //return b.count { b.contains('a') }.toString()
        //val aString = a.toCharArray().sortedArray().distinct().joinToString("")
        //val bString = b.toCharArray().sortedArray().distinct().joinToString("")
        val a = arrayOf(1,2,3,4)
        return (b + a).toCharArray().sortedArray().distinct().joinToString("")
    }

    fun shortest(list: List<Int>): Int {
        return list.min()!!
    }

    fun catDog(years: Int): Array<Int> {

        return arrayOf(0, 15 + if (years == 2) 9 else 0 + if(years > 2) (4*(years - 2)) else 0, 15 + if (years == 2) 9 else 0 + if(years > 2) (5*(years - 2)) else 0)
    }

    fun gencat(years: Int): Int {
        return 15 + if (years == 2) 9 else 0 + if(years > 2) (4*(years - 2) + 9) else 0
    }

    fun gendog(years: Int): Int {
        return 15 + if (years == 2) 9 else 0 + if(years > 2) (5*(years - 2)) else 0
    }

    fun dd(n: Int, d: Int): Int {

        return 0.rangeTo(n).map { it * it}.toIntArray().joinToString("").count { it == d.toString().toCharArray()[0] }
    }

    fun middle(string: String): String {
        return if (string.count() > 2) string.let { if (it.count() % 2 == 0) (it[it.count()/2 - 1] + it[it.count()/2].toString()) else it[it.count()/2].toString() } else string
    }

    fun genA(price: Int, times: Int): Int {
        return price * times
    }
    fun fn(n: Int): BigInteger {
        //var a = 1
        var a: BigInteger = BigInteger.valueOf(1)
        for (i in 1..n) {
            a *= BigInteger.valueOf(2)
        }
        return a
    }
    fun multiReplace(s: String): String {
        //return s.map{when(it){'('->')'')'->'(''<'->'>''>'->'<''{'->'}''}'->'{' else->it}}.joinToString("")
        /*return s.map {
            when(it) {
                '<','{'->it+2
                '>','}'->it-2
                '('->it+1
                ')'->it-1
                else -> it
            }
        }.joinToString("")*/
        return s.map{it+when(it){'<','{'->2 '>','}'->-2 '('->1 ')'->-1 else->0}}.joinToString("")
    }

    //fun f(s:String):String=s.map{it+when(it){'<','{'->2 '>','}'->-2 '('->1 ')'->-1 else->0}}.joinToString("")

    fun Char.ascii() {
        println("$this : ${this.toInt()}")
    }

    /*when (c) {
        '(' -> ')'
        ')' -> '('
        '<' -> '>'
        '>' -> '<'
        '{' -> '}'
        '}' -> '{'
        else -> c
    }*/

    fun mutF(n: Int): Int {
        return if (n == 0) {
            1
        } else {
            n - mutM(mutF(n - 1))
        }
    }

    fun mutM(n: Int): Int {
        return if (n == 0) {
            0
        } else {
            n - mutF(mutM(n - 1))
        }
    }

    fun wallpaper(l: Double, w: Double, h: Double): String {
        // your code
        return if (h * l * w == 0.0) "zero" else when ((((l * h * 2) + (w * h * 2)) / 5.2).let { it + (it * .15) + 1 }.toInt()) {
            0 -> "zero"
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            6 -> "six"
            7 -> "seven"
            8 -> "eight"
            9 -> "nine"
            10 -> "ten"
            11 -> "eleven"
            12 -> "twelve"
            13 -> "thirteen"
            14 -> "fourteen"
            15 -> "fifteen"
            16 -> "sixteen"
            17 -> "seventeen"
            18 -> "eighteen"
            19 -> "nineteen"
            20 -> "twenty"
            else -> ""
        }
    }

    // casting issues
    fun potato(p0: Int, w0: Int, p1: Int): Int = (w0 - ((p0 * w0).toDouble() / 100)).let { (it * 100) / (100 - p1) }.toInt()

    fun ageGuess(ag1: Int, ag2: Int) {
//        (arrayOf(age1, age2, age3, age4, age5, age6, age7, age8).map { it * it }.sum().let { sqrt(it.toDouble()) } / 2).roundToInt()
    }

    class circ<T>(vararg val elements: T) {

        private var current = 0

        init {
            if (elements.isEmpty()) {
                throw Exception()
            }
        }

        fun next(): T {
            return (if (current + 1 > elements.size) elements[0] else elements[current]).also { ++current }
        }

        fun prev(): T {
            return (if (current - 1 < 0) elements.last().also { current = elements.size - 1 } else elements[current - 1].also { --current })
        }
    }
    override fun onEnd() {

    }
}

operator fun<T> String.invoke(data: T): String {
    return data.toString()
}

operator fun Int.get(data: String): Int {
    val a = 1
    a(" ")
    return data.toInt()
}
operator fun Int.invoke(data: String) = data.toInt()
operator fun Long.invoke(data: String) = data.toLong()
operator fun Double.invoke(data: String) = data.toDouble()

fun unless(bool: Boolean, block: () -> (Unit)) {
    if (!bool) {
        block.invoke()
    }
}

fun until(cond: () -> (Boolean), block: () -> (Unit)) {
    while (!cond.invoke()) {
        block.invoke()
    }
}

fun forceRun(block: () -> (Unit)) {
    try {
        block.invoke()
    } catch (e: Exception) {

    }
}

data class Box(var x: Int, var y: Int, var width: Int, var height: Int) {
    fun area() = width * height
    fun rightDown() = width + x to height + y
    fun rightUp() = width + x to height
    fun leftDown() = width to (height + y)

    /*operator fun invoke(init: Box.()->Unit): Box {
        val abc = Box()
        abc.init()
        return abc
    }*/
}

operator fun Box.invoke(init: Box.()->Unit): Box {
    val box = this
    this.init()
    val a = "asd"
    val c = a.onEach{it+when(it){'<','{'->2 '>','}'->-2 '('->1 ')'->-1 else->0}}
    return box
}



val a={a:String->a.map{it+when(it){'<','{'->2 '>','}'->-2 '('->1 ')'->-1 else->0}}.joinToString("")}

fun f(s: String)=s.map{it+when(it){'<','{'->2 '>','}'->-2 '('->1 ')'->-1 else->0}}.joinToString("")
fun ff(a: String) = a.onEach{it+when(it){'<','{'->2 '>','}'->-2 '('->1 ')'->-1 else->0}}

fun s(s: String): String {
    //return s.map{when(it){'('->')'')'->'(''<'->'>''>'->'<''{'->'}''}'->'{' else->it}}.joinToString("")
    /*return s.map {
        when(it) {
            '<','{'->it+2
            '>','}'->it-2
            '('->it+1
            ')'->it-1
            else -> it
        }
    }.joinToString("")*/
    return ""
}


