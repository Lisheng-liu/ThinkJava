package dynamicProxy.jdk;

public class TestJdkDynamicProxy {

    public static void main(String[] args) {

        Star ldh = new LiuDeHua();

        StarProxy proxy = new StarProxy();

        proxy.setTarget(ldh);

        Object obj = proxy.CreatProxyedObj();

        Star star = (Star)obj;

        star.sing("xx");

    }
}
