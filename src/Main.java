import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int month;
        int day;
        int steps;
        int newTarget;
        while (true) {
            printMenu();
            String userInput = scanner.next();
            if (userInput.equals("1")) {
                System.out.println("1.1. Введите номер месяца для учёта (1 - Янв, 2 - Фев и тд...)");
                month = inputMonth(scanner);
                System.out.println("1.2. Введите день от 1 до 30");
                day = inputDay(scanner);
                System.out.println("1.3. Введите кол-во шагов");
                steps = inputSteps(scanner);
                System.out.print("За этот день пройдено " + stepTracker.getMonth(month, day) + " шагов");
                stepTracker.saveMonth(month, day, steps);
                System.out.println(" + пройдено " + steps + " шагов, всего пройдено " + stepTracker.getMonth(month, day) + " шагов.");
                continue;
            }
            if (userInput.equals("2")) {
                System.out.println("Введите номер месяца за который хотите получить статистику (1 - Янв, 2 - Фев и тд...)");
                month = inputMonth(scanner);
                System.out.println(stepTracker.getDailySteps(month));
                System.out.println("Общее количество шагов за месяц " + stepTracker.getStepsQuantity(month));
                System.out.println("Максимальное пройденное количество шагов в месяце " + stepTracker.getMaxStepsQuantity(month));
                System.out.println("Среднее количество шагов " + String.format("%.2f", stepTracker.getAverageQuantity(month)));
                System.out.println("Пройденная дистанция за месяц " + stepTracker.getDistanceKM(month) + " км.");
                System.out.println("Количество сожжённых килокалорий за месяц " + stepTracker.getLostKCal(month) + " ккал.");
                int QtyCheck = stepTracker.getBestSprint(month);
                if (QtyCheck > 1) {
                    System.out.println("Лучшая серия состоит из " + stepTracker.getBestSprint(month) + " дней, когда вы выполнили цель!");
                } else if (QtyCheck == 1) {
                    System.out.println("Вы выполнили цель всего " + stepTracker.getBestSprint(month) + " день! Есть к чему стремится!");
                } else {
                    System.out.println("Вы ни разу не выполнили цель за выбранный период.");
                }
                continue;
            }
            if (userInput.equals("3")) {
                System.out.println("Цель по колличеству шагов в день: " + stepTracker.getTargetStepsQty());
                System.out.println("Введите новую цель: ");
                newTarget = inputSteps(scanner);
                stepTracker.setTargetStepsQty(newTarget);
                System.out.println("Новая цель: " + stepTracker.getTargetStepsQty() + " шагов");
                continue;
            }
            if (userInput.equals("0")) {
                System.out.println("Программа завершена");
                break;
            } else System.out.println("Такой команды нет!");
        }
    }


    private static void printMenu() {
        System.out.println("Счётчик калорий v1.0");
        System.out.println("Что вы хотите сделать:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения.");
    }

    private static int getInt(Scanner scanner) {
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

    private static int inputMonth(Scanner scanner) {
        int i;
        while (true) {
            i = getInt(scanner);
            if (i > 0 && i < 13) break;
            else System.out.println("Введите номер месяца (1 - Янв, 2 - Фев и тд...)");
        }
        return i;
    }
    private static int inputDay(Scanner scanner) {
        int i;
        while (true) {
            i = getInt(scanner);
            if (i > 0 && i < 31) break;
            else System.out.println("Введите день от 1 до 30");
        }
        return i;
    }
    private static int inputSteps(Scanner scanner) {
        int i;
        while (true) {
            i = getInt(scanner);
            if (i >= 0) break;
            else System.out.println("Число не должно быть отрицательным, попробуйте ещё раз: ");
        }
        return i;
    }
}