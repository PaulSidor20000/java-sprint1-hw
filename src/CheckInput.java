import java.util.Scanner;

class CheckInput {

    private int getInt(Scanner scanner) {  // Проверка ввода числа, используется только другими методами
        int i;
        String strConvert;
        while (true) {
            strConvert = scanner.next();
            try {
                i = Integer.parseInt(strConvert);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
        return i;
    }

    int inputMonth(Scanner scanner, int length) {  // Проверка ввода месяца
        int i;
        while (true) {
            i = getInt(scanner);
            if (i >= 1 && i <= length) break;
            else System.out.println("Введите число - номер месяца (1 - Янв, 2 - Фев, ... " + length + " - Дек)");
        }
        return i;
    }

    int inputDay(Scanner scanner, int length) {  // Проверка ввода дня
        int i;
        while (true) {
            i = getInt(scanner);
            if (i >= 1 && i <= length) break;
            else System.out.println("Введите число - номер деня от 1 до " + length);
        }
        return i;
    }

    int inputSteps(Scanner scanner) {  // Проверка ввода шагов
        int i;
        while (true) {
            i = getInt(scanner);
            if (i >= 0) break;
            else System.out.println("Число не должно быть отрицательным, попробуйте ещё раз: ");
        }
        return i;
    }
}