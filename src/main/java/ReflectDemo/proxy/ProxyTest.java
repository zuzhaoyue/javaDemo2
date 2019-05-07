package ReflectDemo.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by zuzhaoyue on 2019/2/18.
 */
public class ProxyTest {
    public static void main(String args[]){

        /*Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                                          new Class[] { Foo.class },
                                          handler);*/
        PersonDao realPersonDao = new PersonDaoImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realPersonDao);
        PersonDao proxy = (PersonDao) Proxy.newProxyInstance(realPersonDao.getClass().getClassLoader(),realPersonDao.getClass().getInterfaces(),myInvocationHandler);
        proxy.say();

    }

}
