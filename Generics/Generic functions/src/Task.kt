import java.util.*
import java.util.function.Predicate

fun <T, C : MutableCollection<T>> Collection<T>.partitionTo(a: C, b: C, test: (T) -> Boolean): Pair<C, C> {
    for (e in this) {
        if (test(e)) {
            a.add(e)
        } else {
            b.add(e)
        }
    }
    return Pair (a, b)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
