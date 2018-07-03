package Arw

import Behavior.CoreLife
import arrow.core.Either

sealed class PlantState {
    object Gone
    class Alive(color: String)
    class Seed(type: String)
}

class Arw {
    fun ee() {
    }
}

object Arww : CoreLife {

    override fun onStart() {
        val a = Either<Arw.PlantState.Gone, Arw.PlantState.Alive>
    }

    override fun onEnd() = Unit
}