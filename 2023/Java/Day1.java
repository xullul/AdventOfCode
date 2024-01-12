// Java 21.0.1

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) {
        String filePath = "../inputs/day1.txt";
        int total = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                char[] charArray = line.toCharArray();
                ArrayList<Character> numbers = new ArrayList<>();

                for (char character : charArray) {
                    if (Character.isDigit(character)) {
                        numbers.add(character);
                    }
                }

                System.out.println("numbers size = " + numbers.size());

                if (numbers.size() >= 2) {
                    String numeric = String.format("%c%c", numbers.get(0), numbers.get(numbers.size() - 1));
                    int number = Integer.parseInt(numeric);
                    total += number;
                } else if (numbers.size() == 1) {
                    String numeric = String.format("%c%c", numbers.get(0), numbers.get(0));
                    int number = Integer.parseInt(numeric);
                    total += number;
                }
            }

            System.out.println(total);
            
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}