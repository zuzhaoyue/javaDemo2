package ReflectDemo.proxy;

import model.Person;

/**
 * Created by zuzhaoyue on 2019/2/19.
 */
public class PersonDaoImpl implements PersonDao {
    public void say() {
        System.out.println("说了一句话");
    }
}
