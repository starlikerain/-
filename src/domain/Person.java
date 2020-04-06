package domain;

public class Person {

    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }


    public void sleep() {
        System.out.println("吃饭打怪睡觉觉...");
    }

    public void eat() {
        System.out.println("也不知道吃了啥");
    }

    public void eat(String food) {
        System.out.println("吃了个寂寞：" + food);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

