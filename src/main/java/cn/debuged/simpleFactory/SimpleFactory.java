package cn.debuged.simpleFactory;


public class SimpleFactory {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation("+");
        double result = operation.getResult(1, 2);
        System.out.println(result);
    }

}

class OperationFactory {
    public static Operation createOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Sub();
                break;
            case "*":
                operation = new Mul();
                break;
            case "/":
                operation = new Div();
                break;
            default:
                break;
        }
        return operation;
    }
}

