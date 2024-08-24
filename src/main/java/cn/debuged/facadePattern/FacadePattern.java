package cn.debuged.facadePattern;

public class FacadePattern {
    public static void main(String[] args) {
        Fund fund = new Fund();
        fund.buy();
        fund.sell();
    }
}

class Stock1 {
    // 卖股票
    public void sell() {
        System.out.println("卖股票1...");
    }

    // 买股票
    public void buy() {
        System.out.println("买股票1...");
    }
}

class Stock2 {
    // 卖股票
    public void sell() {
        System.out.println("卖股票2...");
    }

    // 买股票
    public void buy() {
        System.out.println("买股票2...");
    }
}

class NationalDebt1 {
    // 卖国债
    public void sell() {
        System.out.println("卖 国债...");
    }

    // 买股票
    public void buy() {
        System.out.println("买 国债...");
    }
}

class Realty1 {
    public void sell() {
        System.out.println("卖房地产...");
    }

    public void buy() {
        System.out.println("买房地产...");
    }
}

class Fund {
    Stock1 stock1;
    Stock2 stock2;
    NationalDebt1 nationalDebt1;
    Realty1 realty1;

    public Fund() {
        stock1 = new Stock1();
        stock2 = new Stock2();
        nationalDebt1 = new NationalDebt1();
        realty1 = new Realty1();
    }

    public void buy() {
        stock1.buy();
        stock2.buy();
        nationalDebt1.buy();
        realty1.buy();
    }

    public void sell() {
        stock1.sell();
        stock2.sell();
        nationalDebt1.sell();
        realty1.sell();
    }
}