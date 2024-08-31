package cn.debuged.StatePattern;


import lombok.AllArgsConstructor;
import lombok.Data;

public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.request();
        context.request();
        context.request();
    }
}

abstract class State {
    public abstract void handle(Context context);
}

class ConcreteStateA extends State {
    public void handle(Context context) {
        System.out.println("当前状态是A");
        context.setState(new ConcreteStateB());
    }
}
class ConcreteStateB extends State {

    @Override
    public void handle(Context context) {

        context.setState(new ConcreteStateA());
    }
}

@Data
@AllArgsConstructor
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态：" + this.state.getClass().getName());
    }

    public void request() {
        this.state.handle(this);
    }

}
