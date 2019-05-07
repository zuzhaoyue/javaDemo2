package model;

/**
 * Created by zuzhaoyue on 2019/2/14.
 */
public class Person {
    private String name;
    private int age;

    private Person()
    {

    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("大家好,我是" + this.name + ",今年" + age + "岁!");
    }
    public void say2(String friend){
        System.out.println("大家好,我是" + this.name + ",今年" + age + "岁!" + "我最好的朋友是" + friend);
    }
    public String say3(String enName){
        System.out.println("英文名是"+enName+"....瞎说一气,重点是返回值。");
        return "hello world";
    }
}
