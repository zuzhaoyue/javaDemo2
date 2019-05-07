package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuzhaoyue on 2019/2/13.
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("model.Person");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz4 = classLoader.loadClass("model.Person");
        System.out.println(clazz);
        System.out.println(clazz4);

        //得到所有的构造方法
        /*Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor:constructors){
            System.out.println("构造方法:"+constructor);
            A a = (A) constructor.newInstance("aa",11);
            System.out.println("A a:"+a.getAge());
        }*/

        //得到单个带参构造方法,不带参的类似
        Constructor constructor = clazz.getConstructor(String.class,int.class);//返回构造方法对象,通过Class对象使用其中的成员变量对象
        System.out.println("带参构造方法"+constructor);
        Object p1 =  constructor.newInstance("zzy",11);
        System.out.println(p1.toString());

        //访问私有的构造方法
        Constructor privateConstructor = clazz.getDeclaredConstructor();
        System.out.println("私有构造方法:" + privateConstructor);
        privateConstructor.setAccessible(true);//暴力访问
        Object p2 = privateConstructor.newInstance();
        System.out.println(p2.toString());

        /*//获取成员变量
        Field[] fields = clazz.getDeclaredFields();//获取所有的成员变量
        for(Field field:fields){
            System.out.println("成员变量:" + field);
        }*/
        //给成员变量赋值
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);//因为是私有的,所以又来暴力访问了
        name.set(p2,"aaaaa");//给p2的name属性赋值
        System.out.println(p2.toString());

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p2,13);
        System.out.println(p2.toString());


        //method的调用
//        Method[] methods = clazz.getMethods();//获取自己的及父亲的方法
        Method[] methods = clazz.getDeclaredMethods();//获取自己的方法,不包括父亲的
        for(Method method:methods){
            String name1 = method.getName();
            Class[] arg = method.getParameterTypes();
            System.out.println("方法名:" + name1);
            for(Class a: arg){
                System.out.println("参数类型:" + a);
            }
        }

        Method method =  clazz.getDeclaredMethod("say");//获取一个方法
        method.invoke(p2);//调用

        Method method1 = clazz.getMethod("say2",String.class);
        method1.invoke(p2,"祖祖侠");

        Method method2 = clazz.getMethod("say3",String.class);
        Object object = method2.invoke(p2,"mm");
        System.out.println("返回值:" + object);


        //跳过泛型检查
        List<String> list = new ArrayList<String>();

        Class clazz1 = list.getClass();

        Method addMethod = clazz1.getMethod("add",Object.class);

        addMethod.invoke(list,11);
        addMethod.invoke(list,22);
        addMethod.invoke(list,33);
        System.out.println(list.toString());


        //
        Person person = new Person();
        new ReflectTest().setProperty(person,"name","asasa");
        System.out.println(person);

    }
//给任意对象的属性赋值的方法
    public void setProperty(Object object,String fieldName,Object value) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = object.getClass();
        Field  field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object,value);
    }
}
class Person{
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
