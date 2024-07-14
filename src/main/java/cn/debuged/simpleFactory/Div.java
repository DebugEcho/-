package cn.debuged.simpleFactory;

public class Div extends Operation {
    public double getResult(double numberA, double numberB) {
        if (numberB == 0) {
            throw new ArithmeticException("除数不能为0");
        }
        return numberA / numberB;
    }
}
