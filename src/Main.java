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
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("1.1. Введите номер месяца для учёта (1 - Янв, 2 - Фев и тд...)");
                    month  = scanner.nextInt();
                System.out.println("1.2. Введите день от 1 до 30");
                    day = scanner.nextInt();
                System.out.println("1.3. Введите кол-во шагов");
                while (true) {
                    steps = scanner.nextInt();
                    if (steps >= 0) {
                        System.out.print("За этот день пройдено " + stepTracker.getMonth(month, day) + " шагов");
                        stepTracker.saveMonth(month, day, steps);
                        System.out.println(" + пройдено " + steps + " шагов, всего пройдено " + stepTracker.getMonth(month, day) + " шагов.");
                        break;
                    } else {
                        System.out.println("Число не должно быть отрицательным, попробуйте ещё раз: ");
                    }
                }
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца за который хотите получить статистику (1 - Янв, 2 - Фев и тд...)");
                    month  = scanner.nextInt();
                System.out.println(stepTracker.getDailySteps(month));
                System.out.println("Общее количество шагов за месяц " + stepTracker.getStepsQuantity(month));
                System.out.println("Максимальное пройденное количество шагов в месяце " + stepTracker.getMaxStepsQuantity(month));
                System.out.println("Среднее количество шагов " + String.format("%.2f",stepTracker.getAverageQuantity(month)));
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
            } else if (userInput == 3) {
                System.out.println("Цель по колличеству шагов в день: " + stepTracker.targetStepsQty);
                System.out.println("Введите новую цель: ");
                while (true) {
                    newTarget = scanner.nextInt();
                    if (newTarget >= 0) {
                        stepTracker.setTargetStepsQty(newTarget);
                        System.out.println("Новая цель: " + stepTracker.targetStepsQty + " шагов");
                        break;
                    } else {
                        System.out.println("Число не должно быть отрицательным, попробуйте ещё раз: ");
                    }
                }
            } else if (userInput == 0) {
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
}