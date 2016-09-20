
/**
 * Removes first **T** element from a **MutableCollection** where a condition is specified
 */
inline fun <T> MutableList<T>.removeFirstWhere(crossinline predicate: (T) -> Boolean) =
    asSequence().toList().asSequence().withIndex()
            .find { v -> predicate.invoke(v.value) }?.let { removeAt(it.index) }?:false

/**
 * Removes all **T** elements meeting a given **predicate**
 */
fun <T> MutableList<T>.removeWhere(predicate: (T) -> Boolean) {
    asSequence().toList().asSequence().filter(predicate)
            .forEach { remove(it) }
}

/**
 * Moves first **T** element found to the top of the **MutableList**
 */
fun <T> MutableList<T>.moveFirstToTop(element: T) =
        indexOf(element).let { if (it == -1) null else it }
            ?.let {
                removeAt(it)
                add(0,element)
            }

/**
 * Moves all **T** elements found to the top of the **MutableList**
 */
fun <T> MutableList<T>.moveToTop(element: T) =
        asSequence().withIndex().toList().asSequence()
            .filter { it.value == element }
            .forEach {
                removeAt(it.index)
                add(0,it.value)
            }

/**
 * Moves first **T** element to the top of the **MutableList** meeting a certain **predicate**
 */
inline fun <T> MutableList<T>.moveFirstToTopWhere(crossinline predicate: (T) -> Boolean) =
        asSequence().toList().asSequence().withIndex().find{ v -> predicate.invoke(v.value) }?.let {
            removeAt(it.index)
            add(0, it.value)
            true
        }?:false

/**
 * Moves all **T** elements to the top that meet a given **predicate**
 */
fun <T> MutableList<T>.moveToTopWhere(predicate: (T) -> Boolean) {
    asSequence().toList().asSequence().withIndex().filter { v -> predicate.invoke(v.value)}
            .forEach {
                removeAt(it.index)
                add(0,it.value)
            }
}

/**
 * Moves first **T** element to the bottom of the **MutableList** meeting a certain **predicate**
 */
inline fun <T> MutableList<T>.moveFirstToBottomWhere(crossinline predicate: (T) -> Boolean) =
        asSequence().toList().asSequence().withIndex().find{ v -> predicate.invoke(v.value) }?.let {
            removeAt(it.index)
            add(size - 1, it.value)
            true
        }?:false

/**
 * Moves all **T** elements to the bottom that meet a given **predicate**
 */
fun <T> MutableList<T>.moveToBottomWhere(predicate: (T) -> Boolean) {
    asSequence().toList().asSequence().withIndex().filter { v -> predicate.invoke(v.value)}
            .forEach {
                removeAt(it.index)
                add(size - 1,it.value)
            }
}