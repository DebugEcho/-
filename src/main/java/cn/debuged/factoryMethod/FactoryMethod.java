package cn.debuged.factoryMethod;


import cn.debuged.simpleFactory.*;

public class FactoryMethod {
    public static void main(String[] args) {

    }
}

class OperationFactory {
    static Operation createOperation(String operation) {
        Operation op;
        IFactory factory = null;
        switch (operation) {
            case "+":
            case "-":
            case "*":
            case "/":
                factory = new FactoryBasic();
                break;
            case "pow":
            case "log":
            default:
                factory = new FactoryAdvanced();
        }
        op = factory.createOperation(operation);
        return op;
    }
}

class FactoryBasic implements IFactory {

    @Override
    public Operation createOperation(String operationType) {
        Operation op = null;
        switch (operationType) {
            case "+":
                op = new Add();
                break;
            case "-":
                op = new Sub();
                break;
            case "*":
                op = new Mul();
                break;
            case "/":
                op = new Div();
        }
        return op;
    }
}

class FactoryAdvanced implements IFactory {

    @Override
    public Operation createOperation(String operationType) {
        Operation op = null;
        switch (operationType) {
            case "pow":
                op = new Pow();
                break;
            case "log":
                op = new Log();
                break;
        }
        return op;
    }
}

interface IFactory {
    Operation createOperation(String operationType);
}

// class AddFactory implements IFactory {
//     public Operation createOperation() {
//         return new Add();
//     }
// }
//
// class SubFactory implements IFactory {
//     public Operation createOperation() {
//         return new Sub();
//     }
// }
//
// class MulFactory implements IFactory {
//     public Operation createOperation() {
//         return new Mul();
//     }
// }
//
// class DivFactory implements IFactory {
//     public Operation createOperation() {
//         return new Div();
//     }
// }