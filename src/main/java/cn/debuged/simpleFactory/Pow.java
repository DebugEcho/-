package cn.debuged.simpleFactory;

public class Pow extends Operation {
    public double getResult(double numberA, double numberB) {
        return Math.pow(numberA, numberB);
    }
}
