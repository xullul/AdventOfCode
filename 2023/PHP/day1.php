<?php
// PHP 8.3.1

$filepath = "../inputs/day1.txt";
$file = fopen($filepath, "r");
$total = 0;

while (($line = fgets($file)) !== false) {
    $numbers = [];

    for ($i = 0; $i < strlen($line); $i++) {
        $char = $line[$i];

        if (is_numeric($char)) {
            array_push($numbers, $char);
        }
    }

    var_dump($numbers);

    if (count($numbers) >= 2) {
        $number = $numbers[0] . $numbers[count($numbers) - 1];
        $total += (int)$number;
    } else if (count($numbers) == 1) {
        $number = $numbers[0] . $numbers[0];
        $total += (int)$number;
    }
}

echo "$total\n";

fclose($file);