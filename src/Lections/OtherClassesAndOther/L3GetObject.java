package Lections.OtherClassesAndOther;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class L3GetObject {//класс для десериализации
    public static void main(String[] args){

        try {
            FileInputStream fis = new FileInputStream("intensive.main");
            ObjectInputStream ois = new ObjectInputStream(fis);//Все аналогично, только output меняем на input
//            L3Course android = (L3Course) ois.readObject();//считываем данный объекта из файла
//            L3Course kotlin = (L3Course) ois.readObject();// (L3Course) преобразует объект в класс L3Course
            L3Course[] objects = (L3Course[]) ois.readObject();
//            System.out.println(android);
//            System.out.println(kotlin);
            System.out.println(Arrays.toString(objects));
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
