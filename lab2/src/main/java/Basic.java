import static java.lang.Math.abs;

public class Basic {

    public static final double eps = 0.0000001;

    public static double cos(double value) {
        if (isSpecial(value)) {
            return Double.NaN;
        }
        double s, an;
        int n;
        n = 0;
        an = 1;
        s = 0;
        while (abs(an) > eps) {
            s += an;
            n++;
            an *= -value * value / (2. * n - 1.0) / (2.0 * n);
        }
        return s;
    }

    public static boolean isSpecial(double x) {
        return Double.isNaN(x) || Double.isInfinite(x);
    }

    private static double lnTaylorMember(double x, int n) {
        if (n % 2 == 0) {
            return 0;
        } else {
            return 2 * Math.pow(x, n) / n;
        }
    }

    public static double ln(double value) {
        if (value <= 0 || isSpecial(value)) {
            return Double.NaN;
        }
        double x = (value - 1) / (value + 1);
        return findSum(x, Basic::lnTaylorMember);
    }

    private static double findSum(double value, FunctionMemberFinder finder) {
        double result = 0;
        double prev = 0;
        double current = Double.MAX_VALUE;
        int n = 0;
        while (Math.abs(current - prev) >= eps) {
            prev = current;
            current = finder.calculate(value, n);
            result += current;
            n += 1;
        }

        return result;
    }

    interface FunctionMemberFinder {
        double calculate(double x, int n);
    }
}
