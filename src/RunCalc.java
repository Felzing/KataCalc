import java.io.IOException;
import java.util.Arrays;

public class RunCalc {
    public static void main(String[] args) throws IOException, IllegalInputExeption, IllegalRomanNumberExeption {
        System.out.println("Калькулятор производит базовые математические операции с арабскими (от 1 до 10) " +
                "и римскими (от I до X) цифрами. \nДанные принимаются в формате 'первая цифра - пробел - вторая цифра' и нажатие Enter " +
                "завершает вычисление. \nОдновременно принимается только одна система счисления.");
        Calculator calculator = new Calculator();
        calculator.compute();


    }
}
