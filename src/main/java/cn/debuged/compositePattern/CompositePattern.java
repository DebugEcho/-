package cn.debuged.compositePattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));
        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));
        root.add(comp);
        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));
        comp.add(comp2);
        Leaf leaf = new Leaf("Leaf C");
        root.add(leaf);
        Leaf leaf2 = new Leaf("Leaf D");
        root.add(leaf2);
        root.remove(leaf2);
        root.display(0);
    }
}

@Data
@AllArgsConstructor
abstract class Component {
    protected String name;

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);
}

class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    public void add(Component component) {
        System.out.println("leaf add to a leaf");
    }

    public void remove(Component component) {
        System.out.println("leaf can't remove");
    }

    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }
}

class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}


