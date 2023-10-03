package algorythms;
import java.text.DecimalFormat;
import java.lang.Math;



    public class NewtonMethodV1 {

        public static void main(String[] args) {
            double x0 = 0;
            double eps = 0.001;
            int iter = 0;
            DecimalFormat decimalFormat = new DecimalFormat("#.#####");

            double x = newtonMethod(x0, eps, iter);
            System.out.println("Корень методом Ньютона: " + x);
            System.out.println("F(x) = " + F(x));
        }

        public static double F(double x) {
            return Math.pow(x, 3) + x - 1;
        }

        public static double dF(double x) {
            return 3 * Math.pow(x, 2) + 1;
        }

        public static double newtonMethod(double x0, double eps, int iter) {
            double x = x0;
            do {
                double fx = F(x);
                double dfx = dF(x);

                x = x - fx / dfx;
                iter++;

                System.out.println("Итерация " + iter + ": x = " + x + ", F(x) = " + F(x));

            } while (Math.abs(F(x)) >= eps);

            return x;
        }
    }
