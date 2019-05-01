package dsl

import Behavior.CoreLife

object DSLLife : CoreLife {

    val robot = operate {
        it turns left
        it turns right
        it runs fast

        goOutside {
            it drives car
            it turns left
            it goes straight

            it drives robot
            it flies "away"
        }
    }


    override fun onStart() {
    }

    override fun onEnd() {
    }
}

    class Robot : Movements() {

        fun goOutside(block: Outside.(Outside) -> (Unit)) {
            val outside = Outside()
            outside.block(outside)
        }
    }

    class Outside : Movements() {

        val car = "car"
        val robot = "robot"

        infix fun drives(vehicle: String) {
            println("Drives a $vehicle")
        }

        infix fun flies(speed: String) {
            println("Flies $speed")
        }
    }

    open class Movements {
        val left = "left"
        val right = "right"
        val straight = "straight"
        val fast = "fast"
        val slow = "slow"

        open infix fun turns(direction: String) {
            println("Turns $direction")
        }

        open infix fun runs(speed: String) {
            println("Runs $speed")
        }

        open infix fun goes(direction: String) {
            println("Goes $direction")
        }



        infix fun Int.isEqualTo(answer: Int) = this == answer


        fun test() {



            1 isEqualTo 1 // true


            (1 + 2) isEqualTo 3 // true




        }

    }


    fun operate(block: Robot.(Robot) -> Unit) {
        val robot = Robot()
        robot.block(robot)
    }

