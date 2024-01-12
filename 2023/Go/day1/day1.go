// Go 1.21.6

package main

import (
	"bufio"
	"errors"
	"fmt"
	"log"
	"os"
	"strconv"
	"unicode"
)

func main() {
	log.SetPrefix("advent of code 2023 day1:")
	log.SetFlags(0)

	var filepath string = "../../inputs/day1.txt"
	file, err := os.Open(filepath)

	if err != nil {
		error_message := fmt.Sprintf("Cannot open file at path \"%v\"", filepath)
		log.Fatal(errors.New(error_message))
	}

	var lines []string
	var total int32 = 0
	var scanner *bufio.Scanner = bufio.NewScanner(file)

	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}

	file.Close()

	for _, line := range lines {
		var numbers []byte

		for i := 0; i < len(line); i++ {
			var character byte = line[i]

			if unicode.IsDigit(rune(character)) {
				numbers = append(numbers, character)
			}
		}

		var number int32 = get_number(numbers)
		total += number
	}

	fmt.Printf("total = %d\n", total)
}

func get_number(numbers []byte) int32 {
	if len(numbers) >= 2 {
		var numeric string = fmt.Sprintf("%c%c", numbers[0], numbers[len(numbers)-1])

		if number, err := strconv.ParseInt(numeric, 10, 32); err == nil {
			return int32(number)
		}
	} else if len(numbers) == 1 {
		var numeric string = fmt.Sprintf("%c%c", numbers[0], numbers[0])

		if number, err := strconv.ParseInt(numeric, 10, 32); err == nil {
			return int32(number)
		}
	}

	return 0
}
