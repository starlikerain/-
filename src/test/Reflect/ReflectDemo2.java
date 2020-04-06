package test.Reflect;

import test.OtherClass.Person;

import java.lang.reflect.Constructor;

/**
 * 从 class 的 constructor 的角度创建一个 Person 实例化对象
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("你的名字", 18);
        System.out.println(person);

        System.out.println("下面是空参构造");
        Constructor<Person> constructor1 = personClass.getConstructor();
        Person person1 = constructor1.newInstance();
        System.out.println(person1);


        System.out.println("空参构造，可以用 class 上的 newInstance 方法");

        Person person2 = personClass.newInstance();


    }
}
