package dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy implements InvocationHandler {

    // 目标类，也就是被代理对象
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 这里增强
        System.out.println("before :谈钱");
        Object result = method.invoke(target,args);
        System.out.println("after :收钱");
        return result;
    }

    public Object CreatProxyedObj()
    {
        /**
         * 由源码可看到是通过 class 的加载是通过字节吗生成的, 且jdk 代理类是有缓存弱引用，再通过class  的构造器反射 构建对象
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

}
