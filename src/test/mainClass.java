package test;

import test.OtherClass.Person;

import java.lang.reflect.Field;

public class mainClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class personClass = Person.class;

        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
