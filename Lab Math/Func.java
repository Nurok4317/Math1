package algorythms;

import java.text.DecimalFormat;

public class Func {

    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        double eps =0.001;
        double x;
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        int iter=0;
        if (F(a) * F(b) > 0) {
            System.out.println("F(a) и F(b) одного знака");
            return;
        }
        do {
            x = (a + b) / 2;
            if (F(a) * F(x) < 0) {
                b = x;
            } else {
                a = x;
            }
            double d=b-a;
            iter++;
            System.out.print(iter+": ");
            System.out.print("a = "+decimalFormat.format(a)+"; ");
            System.out.print("b = "+decimalFormat.format(b)+"; ");
            System.out.print("x = "+decimalFormat.format(x)+"; ");
            System.out.print("d = "+decimalFormat.format(d)+"; ");
            System.out.print("Fa = "+decimalFormat.format(F(a))+"; ");
            System.out.print("Fb = "+decimalFormat.format(F(b))+"; ");
            System.out.println("Fx = "+decimalFormat.format(F(x))+"; ");


        } while (b - a >= eps);

        System.out.println("x = " +decimalFormat.format(x));
        System.out.println("F(x) = " + decimalFormat.format(F(x)));
    }


    public static double F(double x) {
        return Math.pow(x, 3) + x - 1;
    }
}
















