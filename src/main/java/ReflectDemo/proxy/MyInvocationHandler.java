package ReflectDemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zuzhaoyue on 2019/2/18.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object realObject;

    public MyInvocationHandler(Object realObject) {
        this.realObject = realObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(realObject,args);
        System.out.println("after");
        return result;
    }
}
