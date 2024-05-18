package HomeTasks;

import HomeTasks.SideClasses.Book;
import HomeTasks.SideClasses.DaysOfWeekExample;
import HomeTasks.SideClasses.EBook;

import java.util.Scanner;

public class H2 {
        public static void main(String[] args) {
                H2T1();
                H2T2();
                H2T3();
        }

                public static void H2T1() {
                        Scanner scanner = new Scanner(System.in);

                        // Получаем информацию о книге от пользователя
                        System.out.print("Введите название книги: ");
                        String title = scanner.nextLine();

                        System.out.print("Введите автора книги: ");
                        String author = scanner.nextLine();

                        System.out.print("Введите год издания книги: ");
                        short year = scanner.nextShort();

                        // Создаем объект книги
                        Book book = new Book(title, author, year);

                        // Выводим информацию о книге с использованием метода displayInfo()
                        System.out.println("Информация о бумажной книге:");
                        book.displayInfo();

                        // Получаем информацию об электронной книге от пользователя
                        scanner.nextLine();  // Очистка буфера после ввода числа
                        System.out.print("Введите тип файла электронной книги: ");
                        String fileType = scanner.nextLine();

                        // Создаем объект электронной книги
                        EBook eBook = new EBook(title, author, year, fileType);

                        // Выводим информацию об электронной книге с использованием метода displayInfo() класса EBook
                        System.out.println("\nИнформация об электронной книге:");
                        eBook.displayInfo();
                }

                public static void H2T2(){
                        Calculator calculator = new Calculator();
                        calculator.operation.add(5, 7);
                        calculator.operation.multiply(5, 7);
                }
        public static void H2T3(){
                DaysOfWeekExample day = new DaysOfWeekExample();
                day.printInfo();
        }
        }