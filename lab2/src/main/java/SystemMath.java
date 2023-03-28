public class SystemMath {
    private final MathOfLab math;

    public SystemMath(MathOfLab math) {
        this.math = math;
    }

    public double trigonometricFunction(double x) {
        return (Math.pow((((Math.pow((Math.pow((((Math.pow(((math.tan(x) / math.cosec(x)) - math.cos(x)), 3)) + math.sin(x)) - math.cotan(x)), 2)), 2))
                + ((math.cosec(x) - ((math.cos(x) - math.cos(x)) - (math.sec(x) / math.cos(x)))) - ((Math.pow(math.sin(x), 3)) * math.sec(x)))) +
                (math.cotan(x) - math.cosec(x))) + ((math.sec(x) - ((math.sin(x) * (math.cosec(x) / (math.tan(x) / math.sin(x)))) / math.cos(x))) +
                (math.tan(x) / math.tan(x))), 2));
    }

    public double logarithmicFunction(double x) {
        return (((Math.pow((Math.pow((math.log(5, x) * math.log(5, x)), 2)), 3)) * math.log(3, x)) /
                (Math.pow((math.log(10, x) / (Math.pow(math.log(2,x), 3))), 3)));
    }

    public double calculateFunction(double x) {
        if (x <= 0) {
            return trigonometricFunction(x);
        } else {
            return logarithmicFunction(x);
        }
    }
}
