public class MathOfLab {

    public double cos(double x) {
        return Basic.cos(x);
    }

    public double sin(double x) {
        return cos(Math.PI / 2 - x);
    }

    public double tan(double x) {
        return sin(x) / cos(x);
    }

    public double sec(double x) {
        return 1 / cos(x);
    }

    public double cosec(double x) {
        return 1 / sin(x);
    }

    public double cotan(double x) {
        return cos(x) / sin(x);
    }

    public double ln(double x) {
        return Basic.ln(x);
    }

    public double log(int base, double x) {
        return ln(x) / ln(base);
    }
}
