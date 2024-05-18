package Lections;

import Lections.OtherClassesAndOther.Imath;
import Lections.OtherClassesAndOther.L3Course;
import Lections.OtherClassesAndOther.L3Lessons;
import Lections.OtherClassesAndOther.L3Print;
import Lections.ThreadVariants.L3Elements;
import Lections.ThreadVariants.L3Process;
import Lections.ThreadVariants.L3newTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L3 {
    public static void main(String[] args){
//        L3T1();
//        L3T2();
//        L3T3();
//        L3T4();
//        L3T5();
//        L3T6();
//        L3T7();
//        L3T8();
        L3T9();
    }
        public static void L3T1(){
//        Elements obj1 = new Elements();
//        obj1.start();
//        Thread obj2 = new Thread(new newTest());
//        //В случае использования интерфейса создаем объект таким образом
//        obj2.start();
//        Thread obj3 = new Thread(new Runnable() {
//            //Это третий вариант создания потока
//            @Override
//            public void run() {
//                for (int i = 0; i <= 100; i += 5) {
//                    System.out.println("Элемент 3: " + i);
//                }
//            }
//        });
//        obj3.start();
        try {
            URL website = new URL("http://google.com");
            //Этот класс позволяет работать с URL-ссылками
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            //Этот класс позволяет читать определенный канал по байтам
            //.openStream() уже в любом случае активирует один поток
            FileOutputStream fos = new FileOutputStream("data.html");
            fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
            //.transferFrom позволяет переносить данные из сайта в файл
            //(rbc,0,Long.MAX_VALUE):rbc-наш читающий класс,0-точка "старта",Long.MAX_VALUE-количество символов
            //Все классы со словом Stream используют отдельный поток
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void L3T2(){
        L3Process obj = new L3Process();
        obj.start();
        System.out.println("Нажмите на любую клавишу");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();//Запускается сканнер, которыйй ожидает взаимодействия
        obj.exit();
    }
    public static void L3T3(){
        final L3Car bmw = new L3Car();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bmw.moveCar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bmw.stopCar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();//присоединяем к основному потоку
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void L3T4(){
//        Object some = new Object(); Object-глобальный класс, от которого наследуются все остальные
//        L3L4Course android = new L3L4Course(1,"Android");
//        L3L4Course kotlin = new L3L4Course(2,"Kotlin");
        List<L3Course> listOfCourses = new ArrayList<>();
        listOfCourses.add(new L3Course(1,"Android"));
        listOfCourses.add(new L3Course(2,"Kotlin"));
        printList(listOfCourses);

        List<L3Lessons> listOfLessons = new ArrayList<>();
        listOfLessons.add(new L3Lessons(1,"Android"));
        listOfLessons.add(new L3Lessons(2,"Kotlin"));
//        printList(listOfLessons);//Эта строка не работает


//        System.out.println(android.getClass());//getClass выводит название класса, с которым мы работаем
//        System.out.println(android.hashCode());//hashCode выводит хэш-код объекта
//        //Хэшкод-по сути айди объекта
//        System.out.println(android);
//        System.out.println(kotlin);
//        System.out.println(android==kotlin);
//        System.out.println(android.equals(kotlin));
//        String str1 = "Hello";
//        String str2 = "Hello";
//        System.out.println(str1.equals(str2));
    }
//    public static void printList(List<L3Course> list){ // тут у нас конкретика
        public static void printList(List<? extends L3Course> list){// ? показывает, что выбирается любой объект/список, наследуемый от Course
//            for (Object el: list){1 вариант
            for (L3Course el: list){
                System.out.println(el);
        }
    }
    public static void L3T5(){// СЕРИАЛИЗАЦИЯ И ДЕСЕРИАЛИЗАЦИЯ
        L3Course[] objects = {//Также можно сериализировать массивы
                new L3Course(1,"Android"),
                new L3Course(2,"Kotlin")
        };
//        L3Course android = new L3Course(1,"Android");
//        L3Course kotlin = new L3Course(2,"Kotlin");
        try {
            FileOutputStream fos = new FileOutputStream("intensive.main"); //Позволяет работать с открытием и закрытием файлов, также можно написать любое расширение
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(android);//Функция позволяет сериализировать объект
//            oos.writeObject(kotlin);
            oos.writeObject(objects);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void L3T6(){//Лямбда-выражения
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        };
//        Runnable runnable1 = ()-> System.out.println("Hello");
//        //()- параметры, которые функция принимает,-> указывает на тело функции System.out.println("Hello");
        Imath imath  = new Imath() {
            @Override
            public double summ(double a, double b) {
                return a+b;
            }
        };
        System.out.println(imath.summ(5,7));
        Imath imath1 =(a, b) -> a + b;
        System.out.println(imath1.summ(5,7));
    }
    public static void L3T7(){
        Map<String,Boolean> hmap = new HashMap<>();//HashMap-коллекция, где вместо индексов-ключи.
        // 1 пишем тип данных для ключей, 2- тип данных для элементов списка
        hmap.put("first",true);//добавление ключа и его содержимого, соответственно, в список
        hmap.put("first",false);// при повторении ключа значение перезапишется
        hmap.put("hasCar",true);
        hmap.put("hasWife",true);
        boolean hasCar = hmap.get("hasCar");
        System.out.println(hasCar);
        for (Map.Entry<String,Boolean> entry:hmap.entrySet()){
//            В цикле обращаемся к глобальному классу Map, создавая на нем объект, методу entry, вписываем нужные параметры,
//            называем этот объект, обращаемся к нужному списку и методу entrySet
            String key = entry.getKey();//Берет ключ
            boolean value = entry.getValue();// берет значение
            System.out.println(key +"-"+ value);
        }
        Set<String> hashSet = new HashSet<>();//Set -родительский класс для коллекций, где не может быть повторяющихся элементов
        hashSet.add("banana");
        hashSet.add("milk");
        hashSet.add("potato");
        hashSet.add("banana");
        for (String str :hashSet ){
            System.out.println(str);
        }
    }
    public static void L3T8(){
//        List info = new ArrayList();
//        info.add("First");
//        info.add(2);
//        for (Object el:info){
//            System.out.println(el);
//        }
//
        L3Print<String> print1 = new L3Print<>();
        print1.setInfo("First");
        System.out.println(print1.getInfo());
        L3Print<Integer> print2 = new L3Print<>();
        print2.setInfo(4);
        System.out.println(print2.getInfo());
        int info1 = print1.print(new String[]{"Tom", " Alex","Afanasi"},500);
        System.out.println(info1);
        String info2 = print2.<Integer,String>print(new Integer[] {3,55,16},"Add info" );//так писать не обязательно
        System.out.println(info2);
    }
    public static void L3T9(){//StreamAPI позволяет удобнее работать с массивами и коллекциями и работает на лямбда-функциях
        /*Java Stream API предоставляет мощные средства для обработки и манипуляции данными.
        Этот API позволяет выполнять функциональные операции на потоках данных, таких как фильтрация, отображение, сортировка и агрегация, с минимальным объемом кода.
         */
        int [] nums = new int[]{-3,2,4,89,-7,12,-6};
//        int count = 0;
//        for (int i = 0;i<=nums.length;i++)
//            if (nums[i]>0) count+=i;
//        System.out.println(count);
        int sum = IntStream.of(nums).filter(w->w>0).sum();//IntStream позволяет работать с наборами данных из чисел
        //.filter(w->w>0) фильтрует список, отбирая элементы больше нуля
        System.out.println(sum);
        long count = IntStream.of(nums).filter(w->w>0).count();//count() считает количество подходящих элементов
        System.out.println(count);
        IntStream.of(nums).filter(w->w>0&&w<=4).forEach(System.out::println);//.forEach(System.out::println) выводит каждый элемент, подпадающий под фильтр
        IntStream.of(50,40,30,20,10,0).filter(w -> w < 40 && w >= 10).map(w->w+15)//.map(w->w+15) проводит манипулцию с каждым элементом
                .limit(2).forEach(System.out::println);//.limit выводит максимально указанное количество элементов, начиная с начала списка
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World    ");
        list.add("    Fuck  ");
        list.add("Sht");
        Stream<String> stream = list.stream();
        stream.filter(w -> w.trim().length()==4).forEach(System.out::println);//w.trim() удаляет пробелы до и после слова, но не работает почему-то
                //length()==4 выбирает значения, чья длина строки включает 4 символов
    }
}
