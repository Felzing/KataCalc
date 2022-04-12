import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class Calculator {
    public String[] inputRom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public String firstValue;
    public String secondValue;
    public String[] input;
    public BufferedReader reader;

    List<String> mathOperations;
    void mathOpsInit(){
        mathOperations = new ArrayList<>();
        mathOperations.add("+");
        mathOperations.add("-");
        mathOperations.add("*");
        mathOperations.add("/");
    }
    int exCount = 0;

    public Calculator() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine().split(" ");
        mathOpsInit();
        if (input.length == 3 && mathOperations.contains(input[1])){
            firstValue = input[0];
            secondValue = input[2];
        }else {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            exCount++;
        }
        reader.close();
    }

    public String arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            throw new IllegalArgumentException(number + " is not in range (0,100]");
        }

        List <RomanNumbers> romanNumerals = RomanNumbers.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumbers currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
