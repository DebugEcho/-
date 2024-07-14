package cn.debuged.factoryMethod;


import cn.debuged.simpleFactory.*;

public class FactoryMethod {
    public static void main(String[] args) {

    }
}

class OperationFactory {
    static Operation createOperation(String operation) {
        Operation op;
        IFactory factory;
        switch (operation) {
            case "+":
                factory = new AddFactory();
                break;
            case "-":
                factory = new SubFactory();
                break;
            case "*":
                factory = new MulFactory();
                break;
            case "/":
            default:
                factory = new DivFactory();
        }
        op = factory.createOperation();
        return op;
    }
}

interface IFactory {
    Operation createOperation();
}

class AddFactory implements IFactory {
    public Operation createOperation() {
        return new Add();
    }
}

class SubFactory implements IFactory {
    public Operation createOperation() {
        return new Sub();
    }
}

class MulFactory implements IFactory {
    public Operation createOperation() {
        return new Mul();
    }
}

class DivFactory implements IFactory {
    public Operation createOperation() {
        return new Div();
    }
}