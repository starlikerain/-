package com.company.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 可以用 lambda 的特性，做性能优化
 * lambda 有延迟加载的功能，必须存在函数式接口
 */

public class main {
    public static void consumer(String[] names, Consumer<String> consumer1, Consumer<String> consumer2) {
        for (String name : names) {
            consumer1.andThen(consumer2).accept(name);
        }
    }

    public static void main(String[] args) {
        String[] names = {"迪丽热巴,女","段,女","哈撒给,男"};

        consumer(names,
                (name) -> {
                    String[] nameAndSex = name.split(",");
                    System.out.print("名称是:"+ nameAndSex[0]);
                },
                (name) -> {
                    String[] nameAndSex = name.split(",");
                    System.out.println("性别是:"+ nameAndSex[1]);
                }
                );
    }
}
