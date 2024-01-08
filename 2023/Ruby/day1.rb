file = File.open('../inputs/day1.txt')
text = file.read

total = 0

for line in text.lines do
  numbers = Array.new
  number = 0

  line.each_char do |character|
    begin
      number = Integer(character)
      numbers.push(number)
    rescue ArgumentError
    end
  end

  if numbers.length >= 2
    number = "#{numbers[0]}#{numbers[numbers.length - 1]}".to_i
  elsif numbers.length == 1
    number = "#{numbers[0]}#{numbers[0]}".to_i
  else
    number = 0
  end

  total += number
end

puts total
