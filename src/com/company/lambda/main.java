package com.company.lambda;

import java.util.function.Function;

/**
 * 可以用 lambda 的特性，做性能优化
 * lambda 有延迟加载的功能，必须存在函数式接口
 */

public class main {
    public static void chage(String s, Function<String, Integer> fun){
        Integer in = fun.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        String s = "1234";

        chage(s, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });

    }
}
