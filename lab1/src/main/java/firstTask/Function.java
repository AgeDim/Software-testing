package firstTask;

import static java.lang.Math.*;

public class Function {
    private double dfact(int n) {
        double res = 1.0;
        for (int i = n; i >= 1; i -= 2) {
            res *= i;
        }
        return res;
    }

    public double arcsin(double x) throws InfinityValueException {
        double eps = 1e-2; //точность
        double retVal = 0;
        int k = 1;
        double prev = 0;   //предыдущее значение для сравнения
        do {
            prev = retVal;
            retVal += (dfact(2 * k - 1) * pow(x, 2 * k + 1))
                    / (dfact(2 * k) * 2 * k + 1);
            k++;
        } while ((abs(retVal - prev)) > eps);
        if (retVal + x == Double.NEGATIVE_INFINITY || retVal + x == Double.POSITIVE_INFINITY)
            throw new InfinityValueException("Infinity");
        return retVal + x;
    }
}
