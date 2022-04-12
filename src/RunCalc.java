import java.io.IOException;
import java.util.Arrays;

public class RunCalc {
    public static void main(String[] args) throws IOException {
        System.out.println("Калькулятор производит базовые математические операции с арабскими (от 1 до 10) " +
                "и римскими (от I до X) цифрами. \nДанные принимаются в формате 'первая цифра - пробел - вторая цифра' и нажатие Enter " +
                "завершает вычисление. \nОдновременно принимается только одна система счисления.");
        Calculator calculator = new Calculator();
        String exStarter;

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
            }else exStarter = calculator.arabicToRoman(first) +  calculator.arabicToRoman(second);
        }catch (IllegalArgumentException e){
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
                if(calculator.exCount == 0)
                {
                    System.out.println("Используются одновременно разные системы счисления");
                }
            }
        }
    }
}
