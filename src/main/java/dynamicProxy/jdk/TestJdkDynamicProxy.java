package dynamicProxy.jdk;

public class TestJdkDynamicProxy {

    public static void main(String[] args) {

        Star ldh = new LiuDeHua();

        StarProxy proxy = new StarProxy();

        proxy.setTarget(ldh);

        long time5 = System.currentTimeMillis();
        Object obj = proxy.CreatProxyedObj();
        long time6 = System.currentTimeMillis();
        System.out.println("jdk proxy 创建时间：" + (time6 - time5));

        Star star = (Star)obj;

        star.sing("xx");

    }
}
