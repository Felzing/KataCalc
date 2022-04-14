import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Calculator {
    private String[] inputRom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private List<String> legalInputValues = new ArrayList<>();
    private void setLegalInputValues(){
        legalInputValues.add("I");
        legalInputValues.add("II");
        legalInputValues.add("III");
        legalInputValues.add("IV");
        legalInputValues.add("V");
        legalInputValues.add("VI");
        legalInputValues.add("VII");
        legalInputValues.add("VIII");
        legalInputValues.add("IX");
        legalInputValues.add("X");
        legalInputValues.add("1");
        legalInputValues.add("2");
        legalInputValues.add("3");
        legalInputValues.add("4");
        legalInputValues.add("5");
        legalInputValues.add("6");
        legalInputValues.add("7");
        legalInputValues.add("8");
        legalInputValues.add("9");
        legalInputValues.add("10");
    }
    private String firstValue;
    private String secondValue;
    private String[] input;
    private BufferedReader reader;

    private String exStarter;

    public void compute() throws IllegalRomanNumberExeption {
        try {
            int first = Arrays.asList(inputRom).indexOf(firstValue) + 1;
            int second = Arrays.asList(inputRom).indexOf(secondValue) + 1;
            if(first > 0 && second > 0){
                switch (input[1]){
                    case "+":
                        System.out.println(arabicToRoman(first + second));
                        break;
                    case "-":
                        if (first - second < 0) throw new IllegalRomanNumberExeption("В римской системе нет отрицательных чисел");
                        System.out.println(arabicToRoman(first - second));
                        break;
                    case "*":
                        System.out.println(arabicToRoman(first * second));
                        break;
                    case "/":
                        System.out.println(arabicToRoman(first / second));
                }
            }else exStarter = arabicToRoman(first) +  arabicToRoman(second);
        }catch (IllegalArgumentException e){
            try {
                int first = Integer.parseInt(firstValue);
                int second = Integer.parseInt(secondValue);
                switch (input[1]){
                    case "+":
                        System.out.println(first + second);
                        break;
                    case "-":
                        System.out.println(first - second);
                        break;
                    case "*":
                        System.out.println(first * second);
                        break;
                    case "/":
                        System.out.println(first / second);
                }
            }catch (NumberFormatException e1){
                System.out.println("Используются одновременно разные системы счисления");

            }
        }
    }


    private List<String> mathOperations;
    private void mathOpsInit(){
        mathOperations = new ArrayList<>();
        mathOperations.add("+");
        mathOperations.add("-");
        mathOperations.add("*");
        mathOperations.add("/");
    }


    public Calculator() throws IOException, IllegalInputExeption {
        reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine().split(" ");
        setLegalInputValues();
        mathOpsInit();
        if (input.length == 3){
            firstValue = input[0];
            secondValue = input[2];
            if (!legalInputValues.contains(firstValue)||!legalInputValues.contains(secondValue)) {
                throw new IllegalInputExeption("Недопустимый ввод, калькулятор" +
                        " принимает арабские цифры от 1 до 10 или римские цифры от I до X");
            }
            if (!mathOperations.contains(input[1]))throw new  IllegalInputExeption("Введенный символ не является обозначением допустимой математической операции");
        }
        else if(input.length < 3) {
            throw new IllegalInputExeption("Введенная строка не является математической операцией");
            }
        else  throw new IllegalInputExeption("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");



        reader.close();
    }

     private String arabicToRoman(int number) {
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
