

fun main(args: Array<String>) {
    val items: MutableList<String> =
            listOf("Alpha","Beta","Gamma","Apple","Axel","Delta","Epsilon","Adam").toMutableList()


    println(items)

    //move Gamma to top
    items.move("Gamma",0)
    println(items)

    //move all "A" items to top
    items.moveAll(0) { s -> s.startsWith("A") }
    println(items)

    //move "Epsilon" up
    items.moveUp("Epsilon")
    println(items)

    //move item at index 5 to index 3
    items.move(5,3)
    println(items)
}