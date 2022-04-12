import java.io.IOException;
import java.util.Arrays;

public class RunCalc {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        int exStarter = 0;

        try {
            int first = Arrays.asList(calculator.inputRom).indexOf(calculator.firstValue) + 1;
            int second = Arrays.asList(calculator.inputRom).indexOf(calculator.secondValue) + 1;
            if(first > 0 && second > 0){
                switch (calculator.input[1]){
                    case "+":
                        System.out.println(calculator.arabicToRoman(first + second));
                        break;
                    case "-":
                        if (first - second > 0){
                            System.out.println(calculator.arabicToRoman(first - second));
                        }else System.out.println("В римской системе нет отрицательных чисел");
                        break;
                    case "*":
                        System.out.println(calculator.arabicToRoman(first * second));
                        break;
                    case "/":
                        System.out.println(calculator.arabicToRoman(first / second));
                }
            }else exStarter = Integer.parseInt(calculator.firstValue) * Integer.parseInt(calculator.secondValue);
        }catch (NumberFormatException e){
            try {
                int first = Integer.parseInt(calculator.firstValue);
                int second = Integer.parseInt(calculator.secondValue);
                switch (calculator.input[1]){
                    case "+":
                        System.out.println(first + second);
                        break;
                    case "-":
                        if (first - second > 0){
                            System.out.println(first - second);
                        }else System.out.println("В римской системе нет отрицательных чисел");
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
}
