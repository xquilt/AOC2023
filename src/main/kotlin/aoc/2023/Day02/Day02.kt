object Day02 {

    fun parseLine(line: String): List<GameGuess> {
        return line
            .substring(line.indexOf(":") + 1)
            .split(";")
            .map { it
                .split(",")
            }
            .map {
                it
                    .map {
                        it.trim()
                        .split(" ")
                        .let { it.first().toInt() to it.last() }
                    }
            }
            .also { println(it) }
            .map {
                GameGuess(
                    index = line.substring(0, line.indexOf(":")).split(" ").last().toInt(),
                    blue = it.find { it.second == "blue" }?.first ?: 0,
                    red = it.find { it.second == "red" }?.first ?: 0,
                    green = it.find{ it.second == "green" }?.first ?: 0
                )
            }
    }

    fun part1(lines: List<String>, condition: GameGuess): Int {
        return lines
            .map {
                parseLine(it).run {
                    map {
                        if (
                            it.blue <= condition.blue &&
                            it.green <= condition.green &&
                            it.red <= condition.red
                        ) it.index else null
                    }
                }
                .run { if (contains(null)) null else first() }
            }
            .filterNotNull()
            .sum()
    }

    fun minValues(line: String): Int {
        return line
            .substring(line.indexOf(":") + 1)
            .split(";")
            .map { it
                .split(",")
            }
            .flatten()
            .map {
                it
                    .trim()
                    .split(" ")
                    .let { it.first().toInt() to it.last() }
            }
            .groupBy { it.second }
            .mapValues { (_, groupElements) ->
                groupElements.maxBy { it.first }
            }
            .values
            .toList()
            .sortedBy { it.first }
            .also { println(it) }
            .fold(1) { acc, pair -> pair.first * acc }
    }

    fun part2(lines: List<String>): Int {
        return lines
            .map {
                minValues(it)
            }
            .sum()
    }

}
data class GameGuess(val index: Int, val blue: Int, val green: Int, val red: Int)