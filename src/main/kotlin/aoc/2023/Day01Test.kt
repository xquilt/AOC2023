import Day01.part1
import Day01.part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun part1Test() {
        assertEquals(
            142,
            part1("""
                 1abc2
                 pqr3stu8vwx
                 a1b2c3d4e5f
                 treb7uchet
                """.readLines())
        )
    }

    @Test
    fun part1solve() {
        println(part1(readInput("Day01")))
    }

    @Test
    fun part2Test() {
        assertEquals(
            281,
            part2("""
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.readLines())
        )
    }

    @Test
    fun part2solve() {
        println(part2(readInput("Day01")))
    }

    @Test
    fun part2Trial() {
        println(part2(listOf("threeeight16three")))
    }

}