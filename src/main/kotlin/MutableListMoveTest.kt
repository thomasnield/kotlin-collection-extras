
class MutableListMoveTest {
    @org.testng.annotations.Test
    fun test() {
        val items: MutableList<String> =
                listOf("Alpha","Beta","Gamma","Apple","Axel","Delta","Epsilon","Adam").toMutableList()

        //moveAt Gamma to top
        items.move("Gamma",0)
        println(assertTrue())

        //moveAt all "A" items to top
        items.moveAll(0) { s -> s.startsWith("A") }
        println(items)

        //moveAt "Epsilon" up
        items.moveUp("Epsilon")
        println(items)

        //moveAt item at index 5 to index 3
        items.moveAt(5,3)
        println(items)
    }
}