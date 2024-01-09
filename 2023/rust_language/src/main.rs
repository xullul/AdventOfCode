use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn main() -> io::Result<()> {
    let file: File = File::open("../inputs/day1.txt")?;

    let reader: BufReader<File> = BufReader::new(file);

    let mut total: i32 = 0;

    let mut counter: i32 = 0;

    for line in reader.lines() {
        let mut numbers: Vec<char> = Vec::new();
        println!("round {}", &counter + 1);
        println!("text = {:?}", &line);

        for character in line?.chars() {
            if character.is_digit(10) {
                numbers.push(character);
            }
        }

        let mut numeric: String = String::new();

        if numbers.len() >= 2 {
            let first_number: char = numbers[0];
            let last_number: char = numbers[&numbers.len() - 1];

            numeric.push(first_number);
            numeric.push(last_number);

            println!("captured string = {:?}", &numeric);

            let number = convert_int(numeric);

            println!("convert to {}\n", &number);
            total += number;

        } else if numbers.len() == 1 {
            numeric.push(numbers[0]);
            numeric.push(numbers[0]);

            println!("captured string = {:?}", &numeric);

            let number = convert_int(numeric);

            println!("convert to {}\n", &number);
            total += number;
        }

        counter += 1;
    }

    println!("{total}");
    Ok(())
}


fn convert_int(numeric: String) -> i32 {
    match numeric.parse::<i32>() {
        Result::Ok(data) => data,
        Result::Err(err) => {panic!("{:#?}", err)},
    }
}