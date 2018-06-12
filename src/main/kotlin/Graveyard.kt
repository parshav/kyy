import Behavior.CoreLife
import org.jetbrains.annotations.TestOnly
import java.math.BigInteger
import kotlin.math.nextDown
import kotlin.math.roundToInt

object Graveyard : CoreLife { // was Core

    override fun onStart() {
        //assertEquals(expected = "aehrsty", actual = longest("aretheyhere", "yestheyarehere"))
        /*if (longest("aretheyhere", "yestheyarehere") == "aehrsty")
            println("we good")
        else {
            println("Test Fail : Actual Output -> ")
            println(longest("aretheyhere", "yestheyarehere"))
        }*/
        //arethy   yesthar
        //aehrty  aehrsty
        //        aehrsty
        //val a = dd(10,1)
        //println("Middle : ${middle("midsle")}")
        //print("2 : ${fn(4)}")

//        print("multi : ${multiReplace("HI }")}")
        /*'('.ascii()
        ')'.ascii()
        ')'.ascii()
        '('.ascii()
        '<'.ascii()
        '>'.ascii()
        '>'.ascii()
        '<'.ascii()
        '{'.ascii()
        '}'.ascii()
        '}'.ascii()
        '{'.ascii()*/
//        mutF(1)
        print(wallpaper(6.3, 4.5, 3.29))
//        wallpaper(4.toDouble(), 3.5, 3.toDouble())
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

    override fun onEnd() {

    }
}