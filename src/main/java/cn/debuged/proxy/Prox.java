package cn.debuged.proxy;

public class Prox {
    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.request();

    }
    interface ISubject{
        void request();
    }
    static class RealSubject implements ISubject{

        @Override
        public void request() {
            System.out.println("真实的请求");
        }
    }
    static class ProxySubject implements ISubject{
        private RealSubject realSubject;

        public ProxySubject(RealSubject realSubject) {
            this.realSubject = realSubject;
        }

        @Override
        public void request() {
            System.out.println("代理请求");
            realSubject.request();
        }
    }
}
