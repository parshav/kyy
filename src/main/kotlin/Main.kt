class Main {
    companion object {

        private val life = Graveyard

        @JvmStatic fun main(args: Array<String>) {
            println("Kotlin main is running here!")
            life.onStart()
            Runtime.getRuntime().addShutdownHook(object: Thread() {
                override fun run() {
                    life.onEnd()
                }
            })
        }
    }
}