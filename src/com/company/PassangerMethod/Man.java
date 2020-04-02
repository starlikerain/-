package com.company.PassangerMethod;

public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("sayHello from Man");
    }

    public void method(Greetable g) {
        g.greet();
    }

    public void show(){
//        method(() -> {
//            Human human = new Human();
//            human.sayHello();
//        });

//        method(() -> {
//            super.sayHello();
//        });


        method(super::sayHello);
    }



    public static void main(String[] args) {
        new Man().show();
    }
}
