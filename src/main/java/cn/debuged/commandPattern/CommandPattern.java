package cn.debuged.commandPattern;

public class CommandPattern {
    public static void main(String[] args) {
        // Receiver receiver = new Receiver();
        // Command command = new ConcreteCommand(receiver);
        // Invoker invoker = new Invoker();
        // invoker.setOrder(command);
        // invoker.executeCommand();
        Barbecuer barbecuer = new Barbecuer();
        Command bakeMuttonCommand = new BakeMuttonCommand(barbecuer);
        Command bakeChickenWingCommand = new BakeChickenWingCommand(barbecuer);
        Waiter waiter = new Waiter();
        waiter.setOrder(bakeMuttonCommand);
        waiter.notifyCommand();
    }
}

abstract class Command {
    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    public abstract void executeCommand();
}

// class ConcreteCommand extends Command {
//     public ConcreteCommand(Receiver receiver) {
//         super(receiver);
//     }
//
//     public void executeCommand() {
//         receiver.action();
//     }
// }

class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.executeCommand();
    }
}

class Receiver {
    public void action() {
        System.out.println("Receiver 被调用");
    }
}
class Barbecuer{
    public void bakeMutton(){
        System.out.println("烤羊肉串");
    }
    public void bakeChickenWing(){
        System.out.println("烤鸡翅");
    }
}
class BakeMuttonCommand extends Command{

    public BakeMuttonCommand(Barbecuer receiver){
        super(receiver);
    }
    public void executeCommand(){
        receiver.bakeMutton();
    }
}
class BakeChickenWingCommand extends Command{
    private Barbecuer receiver;
    public BakeChickenWingCommand(Barbecuer receiver){
        super(receiver);
    }
    public void executeCommand(){
        receiver.bakeChickenWing();
    }
}
class Waiter{
    private Command command;
    public void setOrder(Command command){
        this.command = command;
    }
    public void notifyCommand(){
        command.executeCommand();
    }
}