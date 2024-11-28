package com.a27Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) {
        //启动一个线程，输出一句话
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("i am ok");
//            }
//        }).start();


        //lambda 改进
        new Thread(() -> {
            System.out.println("i am okey");
        }).start();

        //再改进优化
        Runnable r = () -> {
            System.out.println("lambda 表达式");
        };
        new Thread(r).start();


        //在主方法中调用useEatable()
        Eatable e = new EatableImpl();
        //接口中的默认方法 default void show()
        e.show();
        System.out.println("-------------");
        //接口的静态方法 static void testStaticM()
        Eatable.testStaticM();
        useEatable(e);
        System.out.println("-------useEatable(e);------");
        //匿名内部类
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("niming an apple a day");
            }
        });
        //lambda
        useEatable(() -> {
            System.out.println("lambda an apple a day");
        });
        System.out.println("-----------------");


        useFlyable((String s) -> {
            System.out.println(s);
            System.out.println("----airplan is flying");
        });
        System.out.println("-----方法引用符::---");
        //方法引用符::
        useFlyable(System.out::println);


        useConverter((String s) -> {
            return Integer.parseInt(s);
        });
        //简写
        useConverter(s -> Integer.parseInt(s));
        //引用类方法：lambda表达式被类方法替代的时候，他的形参全部传递给静态方法作参数
        System.out.println("-----方法引用符::--->引用类方法");
        useConverter(Integer::parseInt);


        usePrinter((String s) -> {
            System.out.println(s.toUpperCase());
        });
        usePrinter(s -> System.out.println(s.toUpperCase()));
        //引用对象的实例方法
        System.out.println("-----方法引用符::---引用对象的实例方法");
        PrintString ps = new PrintString();
        usePrinter(ps::printUpper);


        //引用类的实例方法：第一个参数作为调用者，后面的参数全部传递给方法做参数
        useMyString((String s, int x, int y) -> {
            return s.substring(x, y);
        });
        useMyString((s, x, y) -> s.substring(x, y));
        System.out.println("-----方法引用符::---引用类的实例方法");
        useMyString(String::substring);


        //引用构造器（构造方法）
        System.out.println("----------引用构造器（构造方法）---------");
        useStudentBuilder((String name, int age) -> {
            //Student s = new Student(name, age);
            //return s;
            System.out.println("****useStudentBuilder***");
            return new Student(name, age);
        });
        //简写
        useStudentBuilder((name, age) -> new Student(name, age));
        //使用引用构造器
        useStudentBuilder(Student::new);

        System.out.println("-----FunctionalInterface 函数式接口-----");
        //函数式接口FunctionalInterface注解：只有一个抽象方法
        Eatable eat = () -> {
            System.out.println("FunctionalInterface 函数式接口 --eat实现");
        };
        eat.eat();
        //函数式接口作为方法参数
        System.out.println("-------函数式接口作为方法参数-------");
        //1 匿名内部类的方式
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动了");
            }
        });
        //2 lambda改进
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程启动了");
        });

        //函数式接口作为方法的返回值
        System.out.println("---------函数式接口作为方法的返回值----------");
        ArrayList<String> al = new ArrayList<String>();
        al.add("dddd");
        al.add("a");
        al.add("bb");
        al.add("cccccc");
        System.out.println("排序前：" + al);
        Collections.sort(al);
        Collections.sort(al, getComparator());
        System.out.println("排序后：" + al);

        System.out.println("---------常用的函数式接口之supplier----------");
        //supplier接口也被成为生产型接口，用来获取数据
        String strSup = getString(() -> "yes");
        System.out.println("supplier接口获取Str==" + strSup);
        //supplier接口获取数组最大值
        int[] arrNum = {34, 2, 5, 66, 33, 1};
        int maxNum = getMax(() -> {
            int max = arrNum[0];
            for (int i = 1; i < arrNum.length; i++) {
                if (arrNum[i] > max) {
                    max = arrNum[i];
                }
            }
            return max;
        });
        System.out.println("supplier接口获取数组最大值==" + maxNum);

        //Consumer<T>接口也被成为消费型接口，他消费的数据的数据类型由泛型指定
        operatorString("Consumer", s -> System.out.println(s + "--消费型接口")); //System.out::println is ok too

        operatorString("Consumer", s -> System.out.println(new StringBuilder(s).reverse().toString()));
        System.out.println("-----同一个字符串，不同方式消费两次----");
        operatorString("ConsumerInterface", s -> System.out.println(s + "--andThen()消费"),
                s -> System.out.println(new StringBuilder(s).reverse().toString()));
        String[] arrStrConsumer = {"doctor,43", "teacher,53", "engineer,99"};
        printInfo(arrStrConsumer, (str) -> {
            System.out.print("职业：" + str.split(",")[0]);
        }, (String str) -> {
            System.out.println(",工龄：" + str.split(",")[1]);
        });

        //断言predicate<T>函数接口的操作：非与或
        boolean b1 = checkString("hello", (str) -> {
            return str.length() > 8;
        });
        System.out.println("断言predicate<T>函数接口的操作b1=="+b1);
        boolean b2 = checkString("predicate",(str)->str.length()>8);
        System.out.println("断言predicate<T>函数接口的操作b2=="+b2);
        boolean b3 = checkString("truck",(String s)->{return s.length()>8;}, (s)->s.length()<15);
        System.out.println("断言predicate<T>函数接口的操作b3=="+b3);
        //数组中多条信息，按照判断要求筛选出目标数组
        String[] strArr = {"aa,23","lll,32","gg,15","ccc,33","jack,35"};
        ArrayList<String> arrlist = arrFilter(strArr,(String s )->{return s.split(",")[0].length()>3;},
                (s)->Integer.parseInt(s.split(",")[1])>33);
        System.out.println("筛选出目标数组=="+arrlist.toString());

        //函数式接口之Function<k,v>
        convertFunction1("100",(String s)->{return Integer.parseInt(s);});
        //体现单条return语句的不同写法
        convertFunction2("100",(s)->Integer.parseInt(s),integer -> String.valueOf(integer+566));

    }
    //函数式接口之Function<k,v> andThen(Function after)
    private static void convertFunction2(String str, Function<String,Integer> fun1,Function<Integer,String> fun2){
//        int i = fun1.apply(str);
//        String ss = fun2.apply(i);
//        System.out.println("函数式接口之Function<k,v> andThen(Function after)=="+ss);
        String ss = fun1.andThen(fun2).apply(str);
        System.out.println("函数式接口之Function<k,v> andThen(Function after)=="+ss);
    }
    //函数式接口之Function<k,v> apply(T t)
    private static void convertFunction1(String str, Function<String,Integer> fun){
        int i = fun.apply(str);
        System.out.println("函数式接口之Function<k,v>=="+i);
    }

    //数组中多条信息，按照判断要求筛选出目标数组:断言predicate<T>函数接口,两组条件，返回目标数组
    private static ArrayList<String> arrFilter(String[] strArr,Predicate<String> pre1,Predicate<String> pre2){
        ArrayList<String> arrList = new ArrayList<>();
        for (String str : strArr) {
            if (pre1.and(pre2).test(str)) {
                arrList.add(str);
            }
        }
        return arrList;
    }

    //函数式接口之断言predicate<T>函数接口的操作：进行俩个判断结果做组合与/或判断，返回布尔值
    private static boolean checkString(String str,Predicate<String> pre1,Predicate<String> pre2) {
//        boolean b1 = pre1.test(str);
//        boolean b2 = pre2.test(str);
//        boolean b3 = b1 && b2;
//        return b3;
        return pre1.and(pre2).test(str);
        //return pre1.or(pre2).test(str);
    }

    //函数式接口之断言predicate<T>函数接口的操作：进行对象判断，返回布尔值
    private static boolean checkString(String str, Predicate<String> pre) {
        return pre.test(str);
        //需要对其结果进行非操作时使用negate()方法
        //return pre.negate().test(str);
    }


    //函数式接口之Consumer<T>定义一个方法，用不同的方式消费同一一个字符数组，两次 按格式打印
    private static void printInfo(String[] arrStrConsumer, Consumer<String> con1, Consumer<String> con2) {
        for (String str : arrStrConsumer) {
            con1.andThen(con2).accept(str);
        }
    }

    //函数式接口之Consumer<T>定义一个方法，用不同的方式消费同一一个字符串，两次
    private static void operatorString(String str, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(str);
//        con2.accept(str);
        con1.andThen(con2).accept(str);
    }

    //函数式接口之Consumer<T>定义一个方法，消费一个字符串
    //Consumer<T>接口也被成为消费型接口，他消费的数据的数据类型由泛型指定 accept()
    private static void operatorString(String str, Consumer<String> con) {
        con.accept(str);
    }

    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    //函数式接口之Supplier<T>接口也称作生产型接口  get()
    private static String getString(Supplier<String> sup) {
        return sup.get();
    }

    private static Comparator<String> getComparator() {
//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };
//        return comp;

//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length()-s2.length();
//            }
//        };

        return (String s1, String s2) -> s1.length() - s2.length();

    }

    private static void startThread(Runnable r) {
        new Thread(r).start();
    }

    private static void useStudentBuilder(StudentBuilder sb) {
        System.out.println("---进 useStudentBuilder");
        Student stu = sb.build("jack", 13);
        System.out.println("回到 useStudentBuilder");
        System.out.println(stu.getName() + "," + stu.getAge());
        System.out.println("---执行完 useStudentBuilder");
    }

    private static void useMyString(MyString s) {
        String s1 = s.mySubString("promotion", 2, 5);
        System.out.println(s1);
    }

    private static void usePrinter(Printer p) {
        p.printUpperCase("lambda");
    }

    private static void useConverter(Converter c) {
        System.out.println("---进 useConverter");
        int number = c.convert("666");
        System.out.println(number);
        System.out.println("---执行完 useConverter");
    }

    private static void useFlyable(Flyable f) {
        f.fly("fly to the sky");
    }

    private static void useEatable(Eatable e) {
        e.eat();
    }

}
