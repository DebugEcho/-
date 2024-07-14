package cn.debuged.decorator;

public class DecoratorPattern {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.Operation();
        Decorator.ConcreteDecoratorA concreteDecoratorA = new Decorator.ConcreteDecoratorA();
        concreteDecoratorA.setComponent(concreteComponent);
        concreteDecoratorA.Operation();
        Decorator.ConcreteDecoratorB concreteDecoratorB = new Decorator.ConcreteDecoratorB();
        concreteDecoratorB.setComponent(concreteComponent);
        concreteDecoratorB.Operation();
    }
}

abstract class Component {
    public abstract void Operation();
}

// ConcreteComponent类
class ConcreteComponent extends Component {

    @Override
    public void Operation() {
        System.out.println("具体对象实现方法");
    }
}

// Decorator类
abstract class Decorator extends Component {
    protected Component component;

    // 装饰一个Component对象
    public void setComponent(Component component) {
        this.component = component;
    }

    // 重写Operation方法调用实际的component对象的Operation方法
    @Override
    public void Operation() {
        if (component!=null) {
            component.Operation();
        }
    }

    // ConcreteDecoratorA类
    static class ConcreteDecoratorA extends Decorator {
        private String addState;// 本类独有的子段

        @Override
        public void Operation() {
            super.Operation();// 先运行原有的方法
            this.addState = "具体装饰对象A的操作";
            System.out.println(this.addState);
        }
    }

    // ConcreteDecoratorA类
    static class ConcreteDecoratorB extends Decorator {

        @Override
        public void Operation() {
            super.Operation();// 先运行原有的方法
            this.addedBehavior(); // 运行本类独有的功能
        }

        private void addedBehavior() {
            System.out.println("具体装饰对象B的操作");
        }
    }
}
