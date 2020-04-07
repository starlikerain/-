package annotation;

@interface MyAnnotation {

    int age();
    String name() default "张三";
}
