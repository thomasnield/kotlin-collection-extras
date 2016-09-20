
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


/**
 * Moves the given element at specified index up the **MutableList** by one increment
 * unless it is at the top already which will result in no movement
 */
fun <T> MutableList<T>.moveUpAt(index: Int) {
    if (index == 0) return
    if (index < 0 || index >= size) throw Exception("Invalid index $index for MutableList of size $size")
    val newIndex = index + 1
    val item = this[index]
    removeAt(index)
    add(newIndex, item)
}

/**
 * Moves the given element **T** up the **MutableList** by one increment
 * unless it is at the bottom already which will result in no movement
 */
fun <T> MutableList<T>.moveDownAt(index: Int) {
    if (index == size - 1) return
    if (index < 0 || index >= size) throw Exception("Invalid index $index for MutableList of size $size")
    val newIndex = index - 1
    val item = this[index]
    removeAt(index)
    add(newIndex, item)
}

/**
 * Moves the given element **T** up the **MutableList** by an index increment
 * unless it is at the top already which will result in no movement
 */
fun <T> MutableList<T>.moveUp(item: T) {
    val currentIndex = indexOf(item)
    val newIndex = (currentIndex - 1)
    if (currentIndex <=0) return
    remove(item)
    add(newIndex, item)
}

/**
 * Moves the given element **T** up the **MutableList** by an index increment
 * unless it is at the bottom already which will result in no movement
 */
fun <T> MutableList<T>.moveDown(item: T) {
    val currentIndex = indexOf(item)
    val newIndex = (currentIndex + 1)
    if (newIndex >= size)  return
    remove(item)
    add(newIndex, item)
}


/**
 * Moves first element **T** up an index that satisfies the given **predicate**, unless its already at the top
 */
inline fun <T> MutableList<T>.moveFirstUpWhere(crossinline predicate: (T) -> Boolean)  = find(predicate)?.let { moveUp(it) }

/**
 * Moves first element **T** down an index that satisfies the given **predicate**, unless its already at the bottom
 */
inline fun <T> MutableList<T>.moveFirstDownWhere(crossinline predicate: (T) -> Boolean)  = find(predicate)?.let { moveDown(it) }

/**
 * Moves all **T** elements up an index that satisfy the given **predicate**, unless they are already at the top
 */
inline fun <T> MutableList<T>.moveUpWhere(crossinline predicate: (T) -> Boolean)  = asSequence().withIndex()
        .filter { predicate.invoke(it.value) }
        .forEach { moveUpAt(it.index) }

/**
 * Moves all **T** elements down an index that satisfy the given **predicate**, unless they are already at the bottom
 */
inline fun <T> MutableList<T>.moveDownWhere(crossinline predicate: (T) -> Boolean)  = asSequence().withIndex()
        .filter { predicate.invoke(it.value) }
        .forEach { moveDownAt(it.index) }

/**
 * Checks if a given **Collection<T>** contains any elements of another **Collection<T>**
 */
fun <T> Collection<T>.containsAny(collection: Collection<T>) = asSequence().any { it in collection }


/**
 * Checks if a given **Collection<T>** contains all elements of another **Collection<T>**
 */
fun <T> Collection<T>.containsAll(collection: Collection<T>) = asSequence().all { it in collection }


/**
 * Only adds an element to a **MutableList** if it is not already added to it
 */
fun <T> MutableList<T>.addIfAbsent(element: T) = if (element in this) false else add(element)




