package Reflect;


import java.lang.reflect.Method;

@Pro(className = "domain.Person", methodName = "eat")
public class ReflectTest2 {
    public static void main(String[] args) throws Exception {
        // 解释注解
        // 获取该类的字节码文件对象
        Class<ReflectTest2> reflectTest2Class = ReflectTest2.class;

        // 获取上面注解的对象
        // 其实就是在内存中生成了一个该注解接口的子类实现对象
        // 具体就是实现了 Pro 注解里面的注释内容区代码
        Pro annotation = reflectTest2Class.getAnnotation(Pro.class);

        // 调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();

        Class<?> cls = Class.forName(className);
        Object ins = cls.newInstance();


        // 从未实例化的类中获得一个抽象方法
        Method method = cls.getMethod(methodName);
        // 抽象方法 通过类的实例乞求施法
        method.invoke(ins);
    }
}
