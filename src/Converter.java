public class Converter {
    double STEP = 0.75;
    double KCAL = 50;
    double getKM(int steps) {  //  преобразование шагов в километры
        return steps * STEP / 1000;
    }
    double getKKal(int steps) {  //  преобразование шагов в сожжёные ккал
        return steps * KCAL / 1000;
    }
}