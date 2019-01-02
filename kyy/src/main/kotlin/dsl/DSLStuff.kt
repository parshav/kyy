package dsl

class House {

    private val rooms = mutableListOf<Room>()
    fun test() {
        val a = build()
    }



    fun room(init: Room.() -> (Unit)): Room {
        val room = Room()
        room.init()
        rooms.add(room)
        return room
    }

    fun build(): House {
        return house {
            room {

            }
            room {

            }
        }
    }
}
class Room

fun house(init: House.() -> (Unit)): House {
    val house = House()
    house.init()
    return house
}

fun mouse(init: (House) -> (Unit)): House {
    val house = House()
    init.invoke(house)
    return house
}
fun hello() = Unit