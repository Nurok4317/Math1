package algorythms;

import java.text.DecimalFormat;

public class such {

    public static void main(String[] args) {
        double epsilon = 0.001;
        double a = -1.8;
        double b = -1.15;

        // Находим корень с использованием метода хорд
        Result resultChord = chordToRoot(epsilon, a, b);
        printResult("Метод секущих", resultChord);
    }

    public static double f(double x) {
        return Math.sin(x) - Math.pow(x / 2 + 2, 0.25) + 2;
    }

    public static Result chordToRoot(double epsilon, double a, double b) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");


        double x0, x1, x, fx;
        int iterations = 0;

        if (f(a) * f(b) > 0) {
            // Проверка наличия корня на заданном интервале
            System.out.println("На заданном интервале [a, b] корень не существует.");
            return new Result(Double.NaN, iterations);
        }

        // Инициализация метода хорд с начальными точками a и b
        if (Math.abs(f(a)) < Math.abs(f(b))) {
            x0 = a;
            x1 = b;
        } else {
            x0 = b;
            x1 = a;
        }

        double fa = f(x0);
        double fb = f(x1);

        do {
            x = x1 - fb * (x1 - x0) / (fb - fa); // Метод cекущих
            fx = f(x);

            if (fx * fa > 0) {
                x0 = x;
                fa = fx;
            } else {
                x1 = x;
                fb = fx;
            }

            iterations++;

            System.out.println("Итерация " + iterations + ":");
            System.out.println("a = " + decimalFormat.format(x0) + ", b = " + decimalFormat.format(x1) + ", x = " + decimalFormat.format(x));
            System.out.println("f(a) = " + decimalFormat.format(fa) + ", f(b) = " + decimalFormat.format(fb) + ", f(x) = " + decimalFormat.format(fx));
        } while (Math.abs(fx) > epsilon);

        return new Result(x, iterations);
    }

    public static void printResult(String methodName, Result result) {
        if (!Double.isNaN(result.root)) {
            double functionValue = f(result.root);
            System.out.println(methodName + ": ");
            System.out.println("Корень: " + result.root);
            System.out.println("Значение функции в корне: " + functionValue);
            System.out.println("Число шагов: " + result.iterations);
        } else {
            System.out.println(methodName + ": Не удалось найти корень.");
        }
    }

    static class Result {
        double root;
        int iterations;

        Result(double root, int iterations) {
            this.root = root;
            this.iterations = iterations;
        }
    }
}
