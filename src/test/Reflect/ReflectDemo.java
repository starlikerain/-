package test.Reflect;

import test.OtherClass.Person;

import java.lang.reflect.Field;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;
        Person wocao = new Person("卧槽", 18);
        Field a = personClass.getField("a");

        Object o = a.get(wocao);
        System.out.println(o);

        // modify a
        a.set(wocao, "卧槽2");
        System.out.println(wocao);


        Field[] fields = personClass.getFields();
        System.out.println("-----------");
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("开始暴力反射：");
        Field name = personClass.getDeclaredField("name");
        /*
        先从 class 的视角，抽象出一个 field，名为 name
        然后用这个来自 class 的 name 获取被实例化的类 Person 的 field
         */
        name.setAccessible(true);
        Object _name = name.get(wocao);
        System.out.println(_name);
    }
}
