package cn.debuged.simpleFactory;

public class Log extends Operation {
    public double getResult(double numberA, double numberB) {
        return Math.log(numberA) / Math.log(numberB);
    }
}
