//import Day01.indexAll

object Day01 {

    fun part1(input: List<String>): Int {
        return input
            .map { it.toCharArray().filter { it.isDigit() } }
            .map { listOf(it.first(), it.last()) }
            .map { it.joinToString("").toInt() }
            .sum()
    }

    fun part2(input: List<String>): Int {
        val numbers = listOf(
             "one",
             "two",
             "three",
             "four",
             "five",
             "six",
             "seven",
             "eight",
             "nine",
        ).zip((1..9))
        return input
            .map { word ->
                numbers
                    .map { pair -> word.indexAll(pair.first).map { it to pair.second } }
                    .flatten()
                    .filterNot { it.first == -1 }
                    .toMutableList()
                    .apply {
                        word.forEachIndexed { index, c ->
                            if (c.isDigit()) add(index to c.digitToInt())
                        }
                    }
                    .also { println(it) }
                    .sortedBy { it.first }
                    .map { it.second }
                    .also { println(word);println(it) }
                    .let { listOf(it.first(), it.last()) }

            }
            .map { it.joinToString("").toInt() }
            .sum()
    }

}