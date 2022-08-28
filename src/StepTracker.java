/*
Класс StepTracker:
Создаёт на основе класса MonthData и через конструктор StepTracker
12 объектов по числу месяцев
- сохраняет передаваемое кол-во шагов, номер дня и месяца методом saveMonth
- возвращает кол-во шагов за нужный месяц и день методом getMonth
- считает статистику
 */
class StepTracker {
    MonthData[] monthToData;
    private int targetStepsQty = 10000;  // Целевое значение кол-ва шагов
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void saveMonth(int month, int day, int steps) {
        monthToData[month - 1].setSteps(day, steps);
    }

    int getMonth(int month, int day) {
        return monthToData[month - 1].getSteps(day);
    }

    String getDailySteps(int month) {  // Статистика - Количество пройденных шагов по дням
        StringBuilder StepsQuantity = new StringBuilder();
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            if (i != monthToData[month - 1].stepsPerDay.length - 1) {  // Проверка последнего дня для исключения запятой в конце строки
                if ((i + 1) % 5 == 0) {
                    StepsQuantity.append(String.format("%3d день: %5d, \n", i + 1, getMonth(month, i + 1)));
                } else {
                    StepsQuantity.append(String.format("%3d день: %5d, ", i + 1, getMonth(month, i + 1)));
                }
            } else {
                StepsQuantity.append(String.format("%3d день: %5d.", i + 1, getMonth(month, i + 1)));
            }
        }
        return StepsQuantity.toString();
    }

    int getStepsQuantity(int month) {  // Статистика - Общее количество шагов за месяц
        int StepsQuantity = 0;
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            StepsQuantity = StepsQuantity + getMonth(month, i + 1);
        }
        return StepsQuantity;
    }

    int getMaxStepsQuantity(int month) {   //  Статистика - Максимальное пройденное количество шагов в месяце
        int StepsQuantity = 0;
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            if (StepsQuantity < getMonth(month, i + 1)) {
                StepsQuantity = getMonth(month, i + 1);
            }
        }
        return StepsQuantity;
    }

    double getAverageQuantity(int month) {  // Статистика - Среднее количество шагов
        double StepsQuantity = 0;
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            StepsQuantity = StepsQuantity + getMonth(month, i + 1);
        }
        StepsQuantity = StepsQuantity / monthToData[month - 1].stepsPerDay.length;
        return StepsQuantity;
    }

    double getDistanceKM(int month) {  // Статистика - Пройденная дистанция (в км) за месяц
        int StepsQuantity = 0;
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            StepsQuantity = StepsQuantity + getMonth(month, i + 1);
        }
        return converter.getKM((StepsQuantity));
    }

    double getLostKCal(int month) {  // Статистика - Количество сожжённых килокалорий за месяц
        int StepsQuantity = 0;
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            StepsQuantity = StepsQuantity + getMonth(month, i + 1);
        }
        return converter.getKKal((StepsQuantity));
    }

    int getBestSprint(int month) {  // Лучшая серия: максимальное количество подряд идущих дней,
        int CurrSprint = 0;      // в течение которых количество шагов за день было равно или выше целевого.
        int BestSprint = 0;
        for (int i = 0; i < monthToData[month - 1].stepsPerDay.length; i++) {
            if (targetStepsQty <= getMonth(month, i + 1)) {
                CurrSprint++;
            } else if (BestSprint < CurrSprint) {
                BestSprint = CurrSprint;
                CurrSprint = 0;
            } else CurrSprint = 0;
        }
        if (BestSprint < CurrSprint) BestSprint = CurrSprint;
        return BestSprint;
    }

    void setTargetStepsQty(int targetStepsQty) {  // Меняем целевое значение кол-ва шагов
        this.targetStepsQty = targetStepsQty;
    }

    int getTargetStepsQty() {  // Запрос целевого значение кол-ва шагов
        return targetStepsQty;
    }
}