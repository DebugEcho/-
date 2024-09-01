package cn.debuged.mementoPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("On");
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.setState("Off");
        originator.show();
        originator.recoveryMemento(caretaker.getMemento());
        originator.show();
    }
}

@Data
class Originator {
    private String state;

    public void show() {
        System.out.println("状态为：" + state);
    }

    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void recoveryMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
@Data
@AllArgsConstructor
class Memento {
    private String state;

}
@Data
class Caretaker {
    private Memento memento;

}