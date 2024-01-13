class Day1
{
    public static void Main()
    {
        string filePath = "../../inputs/day1.txt";
        int total = 0;

        using (StreamReader reader = new StreamReader(filePath))
        {
            while (!reader.EndOfStream)
            {
                string? line = reader.ReadLine();
                List<char> numbers = new List<char>();

                if (line == null)
                {
                    continue;
                }

                foreach (char character in line)
                {
                    if (char.IsDigit(character))
                    {
                        numbers.Add(character);
                    }
                }
                
                if (numbers.Count >= 2)
                {
                    string numeric = $"{numbers[0]}{numbers[numbers.Count - 1]}";
                    int number = Int32.Parse(numeric);
                    total += number;
                } else if (numbers.Count == 1)
                {
                    string numeric = $"{numbers[0]}{numbers[0]}";
                    int number = Int32.Parse(numeric);
                    total += number;
                }
            }

            Console.WriteLine($"total = {total}");
        }
    }
}