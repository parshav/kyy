package Arw

import Behavior.CoreLife
import arrow.core.*

sealed class PlantState {
    object Gone : PlantState()
    class Alive(color: String) : PlantState()
    class Seed(type: String) : PlantState()
}

class Arw {
    fun ee() {
    }
}

object Arww : CoreLife {

    override fun onStart() {

        val a: Either<PlantState.Gone, PlantState.Alive> = PlantState.Gone.left()
        val b: Option<PlantState> = PlantState.Alive("").some()
        val c = Option.functor()
    }

    override fun onEnd() = Unit
}