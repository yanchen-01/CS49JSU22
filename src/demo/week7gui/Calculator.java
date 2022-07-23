package demo.week7gui;

/**
 * An utility class to calculate the monthly payment.
 */
public class Calculator {
    /**
     * Calculate monthly payment
     * @param P principle
     * @param R monthly interest rate
     * @param N number of month
     * @param T tax & fees
     * @return monthly payment
     */
    public static double calculate(double P, double R, int N, double T) {
        if (R == 0.0)
            return P / N + T;
        else {
            double temp = Math.pow(1 + R, -N);
            return P * R / (1 - temp) + T;
        }
    }

}
