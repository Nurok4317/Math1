package algorythms;

import java.text.DecimalFormat;

public class NewtonMethod2 {

    public static void main(String[] args) {
        double x0 = -1.8;
        double eps = 0.001;
        int iter = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        double x = newtonMethod(x0, eps, iter);
        System.out.println("Корень методом Ньютона: " + x);
        System.out.println("F(x) = " + F(x));
    }

    public static double F(double x) {
        return Math.sin(x) - Math.pow(x / 2 + 2, 0.25) + 2;
    }

    public static double dF(double x) {
        return Math.cos(x) - 0.25 * Math.pow(x / 2 + 2, -0.75) * 0.5;
    }

    public static double newtonMethod(double x0, double eps, int iter) {
        double x = x0;
        do {
            double fx = F(x);
            double dfx = dF(x);

            x = x - fx / dfx;
            iter++;

            System.out.println("Итерация " + iter + ": x = "  + ", F(x) = " + F(x));

        } while (Math.abs(F(x)) >= eps);

        return x;
    }
}
