package cn.debuged.bridgePattern;

public class BridgePattern {
    public static void main(String[] args) {
        HandsetBrand ab = new HandsetBrandM();
        ab.setHandsetSoft(new HandsetGame());
        ab.run();
        ab.setHandsetSoft(new HandsetAddressList());
        ab.run();
    }
}

// 手机软件
abstract class HandsetSoft{
    // 运行
    public abstract void run();
}
class HandsetGame extends HandsetSoft{
    @Override
    public void run() {
        System.out.println("运行手机游戏");
    }
}
class HandsetAddressList extends HandsetSoft{
    @Override
    public void run() {
        System.out.println("运行手机通讯录");
    }
}
abstract class HandsetBrand{
    protected HandsetSoft soft;
    public void setHandsetSoft(HandsetSoft soft) {
        this.soft = soft;
    }
    public abstract void run();
}
class HandsetBrandM extends HandsetBrand{
    @Override
    public void run() {
        System.out.println("手机品牌M");
        soft.run();
    }
}
class HandsetBrandN extends HandsetBrand{
    @Override
    public void run() {
        System.out.println("手机品牌N");
        soft.run();
    }
}
