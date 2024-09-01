package cn.debuged.adapterPattern;

public class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
class Target {
    public void request(){
        System.out.println("普通请求！");
    }
}
class Adaptee {
    public void specificRequest(){
        System.out.println("特殊请求！");
    }
}
class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    public void request(){
        adaptee.specificRequest();
    }
}
