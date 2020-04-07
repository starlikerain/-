package Reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

    String className();
    String methodName();
}


// getAnnotation 实现了下面的东西

//public class ProImpl implements Pro {
//    @Override
//    public String className() {
//        return "domain.Person";
//    }
//
//    @Override
//    public String methodName() {
//        return "eat";
//    }
//}