package dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        // 这里增强
        System.out.println("before :谈钱");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after :收钱");
        return result;
    }

    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中,基于类 的代理
    public Object CreatProxyedObj(Class<?> clazz)
    {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }
}
