import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun parseLineTest() {
        assert(
            Day02.parseLine("Game 1: 4 blue, 4 red, 16 green; 14 green, 5 red; 1 blue, 3 red, 5 green").also { println(it) } ==
            listOf(GameGuess(index = 1, green = 16, red = 4, blue = 4), GameGuess(index = 1, green = 14, red = 5, blue = 0), GameGuess(index = 1, blue = 1, red = 3, green = 5))
        )
    }

    @Test
    fun part2Test() {
        assert(
            Day02.part1("""
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 400: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """.readLines(), condition = GameGuess(index = 0, blue = 14, green = 13, red = 12)) ==
            406
        )
    }

    @Test
    fun part2Value() {
        println(
            Day02.part1(
                readInput("Day02"),
                GameGuess(index = 0, red = 12, green = 13, blue = 14)
            )
        )
    }

    @Test
    fun minValueTest() {
        assert(
            Day02.minValues("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green").also { println(it) } ==
            48
        )
    }

    @Test
    fun part2Val() {
        println(Day02.part2(readInput("Day02")))
    }

}