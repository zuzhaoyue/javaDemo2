package DesignPattern;

public class SingletonTest {
    private SingletonTest(){}
    private static SingletonTest instance;

    public static SingletonTest getInstance(){
        if(instance == null){
            synchronized (SingletonTest.class){
                if(instance == null){
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }
}
