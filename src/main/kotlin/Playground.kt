class Playground {

    val a: String? = null
    val b: String? = null
    fun tes(abc: Fighter) {
        when(abc) {
            is ninjat -> abc.int
            is stealth -> abc.int
        }
    }

    companion object {
        fun maker() {
            print("this is the maker")
        }
    }
}

fun tes() {
    val a = Playground
    a.maker()
}
sealed class Fighter
sealed class Winner

interface Nameable
interface NotNameable


class ninjat(val int: Int) : Fighter()
data class stealth(val int: Int) : Fighter()
