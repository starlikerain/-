package annotionTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws IOException {

        Calculator c = new Calculator(); // 创建计算器对象

        Class<? extends Calculator> cls = c.getClass();// 获取字节码文件对象

        Method[] methods = cls.getMethods();//         获取所有方法

        int number = 0; // 出现异常的次数

        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) { //  查看当前的方法，是不是加了 Check 注解 （理解： 注解本身也是 class ，所以 .class 来获取）
                try {
                    method.invoke(c); // 也就是说，如果方法上写了 Check 注解，那么执行内置的 Calculator 计算器对象，让内置的 Calculator 来判断计算是否出错
                } catch (Exception e) { //        捕获异常
                    number++;

                    bw.write(method.getName() + "方法异常了");
                    bw.newLine();

                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();

                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次一共出现" + number + "次异常");

        bw.flush();
        bw.close();



    }
}
