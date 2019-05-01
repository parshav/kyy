package Arw

import Behavior.CoreLife
import arrow.core.*

sealed class PlantState {
    object Gone : PlantState()
    class Alive(color: String) : PlantState()
    class Seed(type: String) : PlantState()
}

object Arw : CoreLife {

    override fun onStart() {

        val a: Either<PlantState.Gone, PlantState.Alive> = PlantState.Gone.left()
        val b: Option<PlantState> = PlantState.Alive("").some()
        val c = Option.functor()
        val lifted = c.lift { n: Int -> n + 1 }
        val ran = c.run {
            Option("Bye").map {
                "$it Universe"
            }
        }
        lifted(Option(1))
    }

    override fun onEnd() = Unit
}
