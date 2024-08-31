package cn.debuged.builder;

import java.util.ArrayList;
import java.util.List;

public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();
        director.Construct(b1);
        b1.getResult().show();
        director.Construct(b2);
        b2.getResult().show();
    }
}

class Product {
    List<String> parts = new ArrayList<>();

    public void Add(String part) {
        parts.add(part);
    }
    public void show() {
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}
class ConcreteBuilder1 extends Builder {
    Product product = new Product();
    @Override
    public void buildPartA() {
        product.Add("partA");
    }

    @Override
    public void buildPartB() {
        product.Add("partB");
    }

    public Product getResult() {
        return product;
    }
}
class ConcreteBuilder2 extends Builder {
    Product product = new Product();
    @Override
    public void buildPartA() {
        product.Add("partX");
    }

    @Override
    public void buildPartB() {
        product.Add("partY");
    }

    public Product getResult() {
        return product;
    }
}
class Director {
    public void Construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}