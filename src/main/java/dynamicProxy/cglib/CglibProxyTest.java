package dynamicProxy.cglib;

import dynamicProxy.jdk.LiuDeHua;
import dynamicProxy.jdk.Star;

public class CglibProxyTest {

    public static void main(String[] args) {
        CglibProxy proxy2 = new CglibProxy();
        long time5 = System.currentTimeMillis();
        Star star2 = (Star)proxy2.CreatProxyedObj(LiuDeHua.class);
        long time6 = System.currentTimeMillis();
        System.out.println("cglib创建时间：" + (time6 - time5));
        star2.sing("xx");


    }

}
