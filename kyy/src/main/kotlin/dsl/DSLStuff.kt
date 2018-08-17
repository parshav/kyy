package dsl

class House {

    fun test() {
        val a = build()
    }

    fun house(init: House.() -> (Unit)): House {
        val house = House()
        house.init()
        return house
    }

    fun room(init: Room.() -> (Unit)): Room {
        val room = Room()
        room.init()
        return room
    }

    fun build(): House {
        return house {
            room {

            }
            room {
                +"String is this"
            }
        }
    }

    operator fun String.unaryPlus() {
        println(this)
    }
}
class Room
