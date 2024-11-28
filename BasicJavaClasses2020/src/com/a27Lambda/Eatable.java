package com.a27Lambda;

@FunctionalInterface
public interface Eatable {
    void eat();
    //若需要扩展接口，但是又不影响其他实现类报错，可使用Java8以后提供的默认方法，可在实现类中重写
    default void show(){
        System.out.println("show");
        //showPri();
        //testPriM();
    }
    //接口中的静态方法，只能用接口对象调用，因为若有一个实现类实现多个接口就不知该调用哪个接口的静态方法了
    static void testStaticM(){
        System.out.println("test 接口的静态方法");
        //testPriM();
    }
   /* //私有方法 java9
    private void showPri(){
        System.out.println("private showPri()");
    }
    //私有静态方法 java9
    private static void testPriM(){
        System.out.println("test private static");
    }*/
}
