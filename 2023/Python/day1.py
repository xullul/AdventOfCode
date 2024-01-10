# Python 3.12.1

from typing import List


with open('../inputs/day1.txt', mode='r', encoding='utf-8') as f:
    total: int = 0
    numbers: List[str] = []
    
    for line in f.readlines():
        numbers = [character for character in line if character.isnumeric()]
    
        if len(numbers) >= 2:
            first_number = numbers[0]
            last_number = numbers[-1]
            number = int(first_number + last_number)
            total += number
        elif len(numbers) == 1:
            total += int(numbers[0] * 2)
        
    print('answer =', total)