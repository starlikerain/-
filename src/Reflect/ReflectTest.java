package Reflect;

/*
 * 不改变改类的任何方法，可以创建任意类对象，可以执行任意方法
 */

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings("all")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 加载配置文件，创建 Properties 对象
        Properties properties = new Properties();

        // 加载配置文件，转换为一个集合，获取 class 目录下的配置文件
        // 用当前 class 下面的 getClassLoader 方法返回的 getResourceAsStream 方法读取一个 inputStream
        ClassLoader ReflectTestClassLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = ReflectTestClassLoader.getResourceAsStream("pro.properties");

        // 用 properties 实例加载配置文件的 inputStream
        properties.load(resourceAsStream);

        // 读取配置文件中的一些信息，比如配置文件中描述的 类的名字、类下面的方法
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 从顶级对象 Class 中生成一个自用的 class
        Class<?> myClass = Class.forName(className);
        Object myClassInstance = myClass.newInstance();

        Method method = myClass.getMethod(methodName);

        method.invoke(myClassInstance);

    }

    public void show(){
        System.out.println("show function");
    }
}
