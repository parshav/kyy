class Playground {

    val a: String? = null
    val b: String? = null
    fun tes(abc: Fighter) {
        when(abc) {
            is ninjat -> abc.int
            is stealth -> abc.int
        }
    }
}

sealed class Fighter
sealed class Winner

interface Nameable
interface NotNameable


class ninjat(val int: Int) : Fighter()
data class stealth(val int: Int) : Fighter()
