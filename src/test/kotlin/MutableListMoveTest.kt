import org.junit.Assert.assertTrue
import org.junit.Test

class MutableListMoveTest {

    fun buildList() = mutableListOf(1,2,3,4,5,6,7,8,9)

    @Test
    fun moveAllTestToLower() {
        val list = buildList()

        list.moveAll(3) { it >= 7 }

        assertTrue(list == mutableListOf(1,2,3,7,8,9,4,5,6))
    }

    @Test
    fun moveAllTestToUpper() {
        val list = buildList()

        list.moveAll(6) { it in setOf(2,3,4) }

        assertTrue(list == mutableListOf(1,5,6,7,8,9,2,3,4))
    }
    @Test
    fun moveAllTestToMin() {
        val list = buildList()

        list.moveAll(0) { it in setOf(5,8) }

        assertTrue(list == mutableListOf(5,8,1,2,3,4,6,7,9))
    }
    @Test
    fun moveAllTestToMax() {
        val list = buildList()

        list.moveAll(8) { it in setOf(5,7) }

        assertTrue(list == mutableListOf(1,2,3,4,6,8,9,5,7))
    }

}