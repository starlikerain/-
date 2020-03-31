package com.company.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 可以用 lambda 的特性，做性能优化
 * lambda 有延迟加载的功能，必须存在函数式接口
 */

public class main {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("卧槽1");
        list.add("别人的卧槽2");
        list.add("鸭的卧槽3");
        list.add("卧槽4");


        list.stream()
                .filter((s) -> s.startsWith("卧"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);

    }
}
