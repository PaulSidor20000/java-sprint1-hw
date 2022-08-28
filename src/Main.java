import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        CheckInput checkInput = new CheckInput();
        int month;
        int day;
        int steps;
        int newTarget;
        while (true) {
            printMenu();
            String userInput = scanner.next();
            if (userInput.equals("1")) {
                System.out.println("1.1. Введите номер месяца для учёта (1 - Янв, 2 - Фев, ... " + stepTracker.monthToData.length + " - Дек)");
                month = checkInput.inputMonth(scanner, stepTracker.monthToData.length);
                System.out.println("1.2. Введите день от 1 до " + stepTracker.monthToData[month - 1].stepsPerDay.length);
                day = checkInput.inputDay(scanner, stepTracker.monthToData[month - 1].stepsPerDay.length);
                System.out.println("1.3. Введите кол-во шагов");
                steps = checkInput.inputSteps(scanner);
                System.out.print("За этот день пройдено " + stepTracker.getMonth(month, day) + " шагов");
                stepTracker.saveMonth(month, day, steps);
                System.out.println(" + пройдено " + steps + " шагов, всего пройдено " + stepTracker.getMonth(month, day) + " шагов.\n");
                continue;
            }
            if (userInput.equals("2")) {
                System.out.println("Введите номер месяца за который хотите получить статистику (1 - Янв, 2 - Фев, ... " + stepTracker.monthToData.length + " - Дек)");
                month = checkInput.inputMonth(scanner, stepTracker.monthToData.length);
                System.out.println(stepTracker.getDailySteps(month));
                System.out.println("Общее количество шагов за месяц " + stepTracker.getStepsQuantity(month));
                System.out.println("Максимальное пройденное количество шагов в месяце " + stepTracker.getMaxStepsQuantity(month));
                System.out.println("Среднее количество шагов " + String.format("%.2f", stepTracker.getAverageQuantity(month)));
                System.out.println("Пройденная дистанция за месяц " + stepTracker.getDistanceKM(month) + " км.");
                System.out.println("Количество сожжённых килокалорий за месяц " + stepTracker.getLostKCal(month) + " ккал.");
                int QtyCheck = stepTracker.getBestSprint(month);
                if (QtyCheck > 1) {
                    System.out.println("Лучшая серия состоит из " + stepTracker.getBestSprint(month) + " дней, когда вы выполнили цель!\n");
                } else if (QtyCheck == 1) {
                    System.out.println("Вы выполнили цель всего " + stepTracker.getBestSprint(month) + " день! Есть к чему стремится!\n");
                } else {
                    System.out.println("Вы ни разу не выполнили цель за выбранный период.\n");
                }
                continue;
            }
            if (userInput.equals("3")) {
                System.out.println("Цель по колличеству шагов в день: " + stepTracker.getTargetStepsQty());
                System.out.println("Введите новую цель: ");
                newTarget = checkInput.inputSteps(scanner);
                stepTracker.setTargetStepsQty(newTarget);
                System.out.println("Новая цель: " + stepTracker.getTargetStepsQty() + " шагов\n");
                continue;
            }
            if (userInput.equals("0")) {
                System.out.println("Программа завершена");
                break;
            } else System.out.println("Такой команды нет!\n");
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