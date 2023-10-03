package algorythms;

public class RootFinding {

    public static void main(String[] args) {
        double epsilon = 0.001;
        double x0 = -1.8;
        double x1 = -1.75;

        // Находим корень с использованием метода итераций
        Result resultIteration = iterateToRoot(epsilon, x0);
        printResult("Метод итераций", resultIteration);

        // Находим корень с использованием метода деления пополам
        Result resultBisection = bisectToRoot(epsilon, x0, x1);
        printResult("Метод деления пополам", resultBisection);
    }

    public static double f(double x) {
        return Math.sin(x) - Math.pow(x / 2 + 2, 0.25) + 2;
    }

    public static Result iterateToRoot(double epsilon, double x0) {
        double x = x0;
        int iterations = 0;

        do {
            double previousX = x;
            x = x - f(previousX) / fPrime(previousX, epsilon);
            iterations++;
        } while (Math.abs(f(x)) > epsilon );

        return new Result(x, iterations);
    }

    public static Result bisectToRoot(double epsilon, double a, double b) {
        double x;
        int iterations = 0;

        if (f(a) * f(b) >= 0) {
            return new Result(Double.NaN, iterations);
        }

        do {
            x = (a + b) / 2;
            if (f(x) * f(a) < 0) {
                b = x;
            } else {
                a = x;
            }
            iterations++;
        } while ((b - a) / 2 > epsilon  );

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

    public static double fPrime(double x, double epsilon) {
        double h = epsilon;
        return (f(x + h) - f(x)) / h;
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
