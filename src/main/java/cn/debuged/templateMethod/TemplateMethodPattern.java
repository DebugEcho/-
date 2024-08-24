package cn.debuged.templateMethod;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        ConcreteClassA concreteClassA = new ConcreteClassA();
        concreteClassA.templateMethod();
        System.out.println("=====我是分割线=====");
        ConcreteClassB concreteClassB = new ConcreteClassB();
        concreteClassB.templateMethod();
    }
}

abstract class AbstractClass {
    public void templateMethod() {
        PrimitiveOperation1();
        PrimitiveOperation2();
    }

    public abstract void PrimitiveOperation1();

    public abstract void PrimitiveOperation2();
}

class ConcreteClassA extends AbstractClass {

    @Override
    public void PrimitiveOperation1() {
        System.out.println("具体A方法的实现");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("具体A方法的实现");
    }
}
class ConcreteClassB extends AbstractClass {

    @Override
    public void PrimitiveOperation1() {
        System.out.println("具体B方法的实现");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("具体B方法的实现");
    }
}