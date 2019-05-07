package ReflectDemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zuzhaoyue on 2018/9/26.
 */
interface  Interface{
    void dosth();
    void sthElse();
}
class RealObject implements Interface{

    public void dosth() {
        System.out.println("real do sth");
    }

    public void sthElse() {
        System.out.println("real sth else");
    }
}
class SimpleProxy implements Interface{
    private Interface i;

    public SimpleProxy(Interface i) {
        this.i = i;
    }

    public void dosth() {
        System.out.println("-----proxy----");
        i.dosth();
    }

    public void sthElse() {
        System.out.println("-----proxy----");
        i.sthElse();
    }
}

class  SimpleProxyDemo{
    public static void consumer(Interface i){
        i.dosth();
        i.sthElse();
    }
    public static void main(String args[]){
        consumer(new RealObject());//传入真实的对象
        consumer(new SimpleProxy(new RealObject()));//传入代理的对象
    }
}
class DynamicProxyHandler implements InvocationHandler{
    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:" + proxy.getClass() + ",method:"  + method + ",args:" + args );
        if(args != null){
            for(Object arg:args){
                System.out.println(" " + arg);
            }
        }
        return method.invoke(object,args);
    }
}
class SimpleDynamicProxy {
    public static void consumer(Interface i){
        i.dosth();
        i.sthElse();
    }
    public static void main(String args[]){
        RealObject real = new RealObject();
        consumer(real);//这个和静态代理一样
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(real));
        consumer(proxy);



    }

}
