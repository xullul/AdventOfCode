// NodeJS 21.5.0

const fs = require('node:fs');


const filepath = '../inputs/day1.txt';
const number_regex = /(\d)+/;

function getNumberFromLine(line) {
	const numbers = [];

	for (const character of line) {
		if (number_regex.test(character)) {
			numbers.push(character);
		}
	}

	if (numbers.length >= 2) {
		const firstNumber = numbers[0];
		const lastNumber = numbers[numbers.length - 1];
		return `${firstNumber}${lastNumber}` | 0;
	} else if (numbers.length == 1) {
		return `${numbers[0]}${numbers[0]}` | 0;
	} else {
		return 0;
	}
}

fs.readFile(filepath, 'utf-8', (error, data) => {
	if (error) throw error;

	let total = 0;
	const lines = data.split(/\r?\n/);

	for (const line of lines) {
		total +=  getNumberFromLine(line);
	}

	console.log(total);
});