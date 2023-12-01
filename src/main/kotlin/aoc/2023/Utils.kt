import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/resources/aoc/2023/$name.txt").readLines()

fun String.readLines() = trimIndent().split("\n")

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun String.indexAll(value: String): List<Int> = mutableListOf<Int>().let { list ->
    var index = indexOf(value)
    while (index >= 0) {
        list.add(index)
        index = indexOf(value, index + 1)
    }
    list
}