// Scala 3.3.1

import scala.collection.mutable.ArrayBuffer
import scala.io.Source


@main def day1() =
    val filePath: String = "../inputs/day1.txt"
    val source: Source = Source.fromFile(filePath)
    var total: Int = 0
    var count: Int = 0

    for (line <- source.getLines) {
        var numbers: ArrayBuffer[Char] = ArrayBuffer()

        for (character <- line) {
            if (character.isDigit) {
                numbers += character
            }
        }

        if (numbers.length >= 2) {
            val numeric: String = s"${numbers(0)}${numbers(numbers.length - 1)}"
            val number: Int = numeric.toInt
            total += number
        } else if (numbers.length == 1) {
            val numeric: String = s"${numbers(0)}${numbers(0)}"
            val number: Int = numeric.toInt
            total += number
        }

        count += 1
    }

    println(s"total = $total")

    source.close()