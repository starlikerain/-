package test;

import test.OtherClass.Person;

public class mainClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("test.OtherClass.Person");
        Class<?> bClass = Class.forName("test.OtherClass.Person");

        Class personClass = Person.class;

        Person p = new Person("我的名字", 12);
        Class aClass1 = p.getClass();


        System.out.println(aClass);

        System.out.println(personClass);

        System.out.println(aClass1);


//        System.out.println(aClass == personClass == aClass1);
    }
}
