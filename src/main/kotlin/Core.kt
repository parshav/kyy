object Core : CoreLife {

    override fun onStart() {
        //assertEquals(expected = "aehrsty", actual = longest("aretheyhere", "yestheyarehere"))
        if (longest("aretheyhere", "yestheyarehere") == "aehrsty")
            println("we good")
        else {
            println("Test Fail : Actual Output -> ")
            println(longest("aretheyhere", "yestheyarehere"))
        }
        //arethy   yesthar
        //aehrty  aehrsty
        //        aehrsty
        val a = dd(10,1)
        println("Middle : ${middle("midsle")}")
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

    override fun onEnd() {

    }
}