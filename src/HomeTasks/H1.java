package HomeTasks;

import java.io.*;
import java.util.Scanner;

public class H1 {
    public static void main(String[] args){
        H1T1();
        H1T2();
    }
        private static void H1T1(){
        System.out.println("\tЗадача:Напишите программу на языке Java, которая предлагает пользователю ввести целое число.\n" +
                "\tОднако, чтобы предотвратить возможные ошибки ввода, используйте конструкцию try-catch для обработки исключений, связанных с вводом данных.\n" +
                "\n\tШаги:\n" +
                "\n" +
                "1) Попросите пользователя ввести целое число.\n" +
                "2) Используйте конструкцию try-catch для обработки исключений, которые могут возникнуть при вводе.\n" +
                "3) Если ввод успешен (без исключений), выведите введенное число на экран.\n" +
                "4) Если возникает исключение, выведите сообщение об ошибке и предложите пользователю повторить ввод.");
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        boolean correctNumber = false;
        System.out.print("Ведите целое число: ");
        while (!correctNumber) {
            try {

                a = scanner.nextInt();
                correctNumber = true;
            } catch (Exception e) {
                System.out.print("Ошибка, повторите ввод: ");
                scanner.nextLine();//Очищаем буфер, иначе вывод будет бесконечен
            }

        }
        System.out.println("Ваше число - " + a);
    }
    private static void H1T2(){
        System.out.println("Создание файла и работат с ним");
        System.out.println("Условие:Напишите программу на языке Java, которая позволяет пользователю записывать текст в файл и читать текст из файла. Программа должна предоставлять простой интерфейс для ввода текста и выбора действия (запись или чтение) с использованием файлов.\n" +
                "\n" +
                "\n" +
                "Шаги:\n" +
                "\n" +
                "Создайте метод для записи текста в файл.\n" +
                "Создайте метод для чтения текста из файла.\n" +
                "Предложите пользователю выбрать действие: запись или чтение.\n" +
                "В зависимости от выбора пользователя, запросите соответствующий текст (для записи) или выберите файл (для чтения).\n" +
                "Вызовите соответствующий метод для выполнения выбранного действия.\n" +
                "Обработайте возможные исключения, связанные с работой с файлами.");
        File file = new File("h1t2.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner scanner = new Scanner(System.in);
        int n;
        String fullInfo = readInfo();
        System.out.println("Выберите вариант работы с файлом "+file.getName()+": \n1-запись в файл\n2-прочесть файл");
        n = scanner.nextInt();

        switch (n){
            case 1:
                addInfo();
                break;
            case 2:
                fullInfo = readInfo();
                System.out.println(fullInfo);
                break;
            default:
                System.out.println("Ошибка в выборе");
        }

    }
    private static void addInfo(){
        try {
            FileWriter fw = new FileWriter("h1t2.txt",true);//режим добавления
            PrintWriter pw = new PrintWriter(fw);
            Scanner scanner = new Scanner(System.in);
            String line;
            System.out.print("Введите текст: ");
            line = scanner.nextLine();
            pw.println(line);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();        }
    }
    private static String readInfo(){
        BufferedReader br = null;
        String res = "";
        try {
            br = new BufferedReader(new FileReader("h1t2.txt"));
            String line;
            while ((line=br.readLine())!=null){
                res+=line+"\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }
}
