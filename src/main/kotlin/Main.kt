class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Kotlin main is running here!")
            Core.onStart()
            Runtime.getRuntime().addShutdownHook(object: Thread() {
                override fun run() {
                    Core.onEnd()
                }
            })
        }
    }
}