package cn.debuged.Prototype;

/**
 * 原型模式
 */
public class Prototype implements Cloneable{
    private final String id;
    public Prototype(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Clone异常");
        }
        return obj;
    }

    public static void main(String[] args) {
        ConcretePrototype p1 = new ConcretePrototype("编号123456");
        ConcretePrototype clone = (ConcretePrototype) p1.clone();
        System.out.println("原Id："+p1.getId()+"克隆后Id："+clone.getId());
    }
}
class ConcretePrototype extends Prototype{
    public ConcretePrototype(String id) {
        super(id);
    }
}

