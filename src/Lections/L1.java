package Lections;

import java.io.*;
import java.util.Scanner;

public class L1 {
    public static void main(String[] args) {
        System.out.println("1-Отлов и исключение ошибок\n2-Запись и чтение данных из файлов");
        L1T1();
        L1T2();
    }
    private static void L1T1(){
        System.out.println("Отлов и исключение ошибок: ");
        float[] arr = new float[]{2.5f, 7.6f , 1.0f};
        // В случае ошибки программа останавливается или виснет. Код ошибки можно найти в консоли
        //        // В данном случае-ArrayIndexOutOfBoundsException
        //        // Для отлова таких ошибок используется конструкция try-catch
        try {
            System.out.println(arr[3]);
            int res = 100/0;
        }catch (ArrayIndexOutOfBoundsException e) {
            // мы создаем объект е для помещения в него информации об ошибке
            System.out.println("Ошибка: "+e);
            //Теперь программа не остановится, а продолжит работу
        }catch (Exception e) {
            System.out.println("Ошибка: " + e);
            //выводится информация про первую возникшую ошибку в списке строк try
        }finally {
            //finally В любом случае всегда обрабатывается, даже если нет ошибок
            System.out.println("Сработал блок finally");
        }
    }
    private static void L1T2(){
        System.out.println("Запись и чтение данных из файлов");
        //для работы с файлами импортируем класс файла
        File file =new File("text.txt");//в параметр вводим имя файла

        if (!file.exists()){//если такого файла не существует в проекте
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String context = readFile();
        try {
            PrintWriter pw = new PrintWriter(file);//Чтобы записать данные в файл, используем класс PrintWriter
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите нужные данные: ");
            String userInput = scanner.nextLine();
            context +=userInput;
            pw.println(context);

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(readFile());
    }
    private static String readFile(){
        BufferedReader br = null;//Используется для чтения и работы с буферизированными данными, null- это пустое значение
        //Пишем так для более удобного перебирания файлов
        String result = "";
        try {
            br = new BufferedReader(new FileReader("text.txt"));
            //FileReader используется для чтения данных из файла
            String line;
            while ((line = br.readLine())!=null) {
                result+=line+"\n";
                //readLine считывает строки
                //((line = br.readLine())!=null) значит, что мы присваиваем line строку и продолжаем, пока строка не будет пустой
//                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
