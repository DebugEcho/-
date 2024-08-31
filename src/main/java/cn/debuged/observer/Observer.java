package cn.debuged.observer;

import java.util.ArrayList;

public class Observer {
    public static void main(String[] args) {
        Secretary secretary = new Secretary("秘书");
        StockObserver stockObserver1 = new StockObserver("观察者1",secretary);
        StockObserver stockObserver2 = new StockObserver("观察者2",secretary);
        secretary.attach(stockObserver1);
        secretary.attach(stockObserver2);

        secretary.setAction("老板回来了");

        secretary.notifyStockObserver();

    }
}

class Secretary {
    protected String name;

    public Secretary(String name) {
        this.name = name;
    }

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private ArrayList<StockObserver> list = new ArrayList<StockObserver>();

    public void attach(StockObserver observer) {
        list.add(observer);
    }
    public void notifyStockObserver() {
        for (StockObserver observer : list) {
            observer.update();
        }
    }
}

class StockObserver {
    private String name;
    private Secretary sub;

    public StockObserver(String name, Secretary sub) {
        this.name = name;
        this.sub = sub;
    }

    public void update() {
        System.out.println(this.sub.name + ": " + this.sub.getAction() + "!" + this.name + "，请关闭股票行情，赶紧工作。");
    }
}
