object Day03 {
    /**
     * - map every number at each line, with a corresponding range
     *      - a list of mappings per each line
     */
    fun part1(lines: List<String>): Int {
        return lines
            .mapIndexed { lineX, line ->
                var value = 0
                var currentNum = ""
                line
                    .plus(".0")
                    .forEachIndexed { charX, char ->
                        if (char.isDigit()) {
                            currentNum = currentNum.plus(char)
                        } else if (currentNum.isNotEmpty()) {
                            val startIndex = charX - currentNum.length
                            val surroundingChars = listOf(
                                lines.getOrNull(lineX - 1)?.subStringOrNull(startIndex - 1 until startIndex),
                                lines.getOrNull(lineX - 1)?.subStringOrNull(startIndex until charX),
                                lines.getOrNull(lineX - 1)?.subStringOrNull(charX.. charX),

                                line.subStringOrNull(startIndex - 1 until startIndex),
                                line.subStringOrNull(charX.. charX),

                                lines.getOrNull(lineX + 1)?.subStringOrNull(startIndex - 1 until startIndex),
                                lines.getOrNull(lineX + 1)?.subStringOrNull(startIndex until charX),
                                lines.getOrNull(lineX + 1)?.subStringOrNull(charX.. charX),
                            )
                            println(currentNum)
                            println(surroundingChars)
                            surroundingChars
                                .filterNot { it == null || it.replace(".", "").replace("\\d".toRegex(), "").isEmpty() }
                                .let {
                                    println(it)
                                    if (it.isNotEmpty())
                                        value += currentNum.toInt()
                                }
                            currentNum = ""
                        }
                    }
                value
            }
            .sum()
    }

    fun part2(lines: List<String>): Int {
        val ranges = lines
            .mapIndexed { linex, line ->
                "\\b\\d+\\b"
                    .toRegex()
                    .findAll(line)
                    .mapIndexed { index, matchResult ->
                        matchResult.value.toInt() to matchResult.range
                    }
            }
        return lines
            .mapIndexed { lineIndex, s ->
                s
                    .mapIndexed { charIndex, char ->
                        if (char == '*') {
                            var match = false
                            listOf(lineIndex - 1, lineIndex - 1, lineIndex, lineIndex, lineIndex + 1, lineIndex + 1).map { line ->
                                if (match) {
                                    match = false;
                                    ranges.getOrNull(line)?.findLast { charIndex in it.second.first - 1 .. it.second.last + 1 }
                                } else {
                                    match = true;
                                    ranges.getOrNull(line)?.find { charIndex in it.second.first - 1 .. it.second.last + 1 }
                                }
                            }
                            .filterNotNull()
                            .toSet()
                            .toList()
                            .also { println(it) }
                            .run {
                                if (this.size >= 2) this.first().first * this[1].first else 0
                            }
                        } else { null }
                    }
                    .filterNotNull()
            }
            .also { println(it) }
            .flatten()
            .sum()
    }

}