public class MonthData {
    int[] stepsPerDay = new int[30];
    void setSteps(int day, int steps) {
        stepsPerDay[day - 1] = stepsPerDay[day - 1] + steps;
    }
    int getSteps(int day) {
        return stepsPerDay[day - 1];
    }
}