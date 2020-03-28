package com.company.FunctionalInterface;

public class Main {
    public static void show(myFunctionalInterface myfunc){
        myfunc.method();
    }

    public static void main(String[] args) {
        show(new myFunctionalInterfaceImpl());

        show(new myFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("这是匿名内部类");
            }
        });


        show(() -> System.out.println("lambda 表达式出来的"));
    }
}
