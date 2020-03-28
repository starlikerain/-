package com.company.lambda;

/**
 * 可以用 lambda 的特性，做性能优化
 * lambda 有延迟加载的功能，必须存在函数式接口
 */

public class main {
    public static void showMessage(int level, MessageBuilder mb) {
        if (level == 1) {
            System.out.println(mb.buildMessage());
        }

    }


    public static void main(String[] args) {
        String msg1 = "我";
        String msg2 = "你";
        String msg3 = "ta";

        showMessage(2, () -> {
            System.out.println("不满足条件不执行");
            return msg1 + msg2 + msg3;
        });

    }
}
