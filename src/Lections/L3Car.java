package Lections;

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class L3Car {
    public void moveCar() throws InterruptedException {//Сокращенная запись try catch
        synchronized (this) {//synchronized (this) Означает, что мы синхронизируем функции данного класса
            //Синхронизация используется для предотвращения конфликтов при одновременном доступе к ресурсам несколькими потоками.
            System.out.println("Car is moving");
            wait();// wait останавливает поток, в скобках можно написать время, на которое останавливает
            System.out.println("Car stopped");
        }
    }
    public void stopCar() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
            synchronized (this){
                System.out.println("Нажмите что-то для остановки");
                scanner.nextLine();
                notify();//notify() возобновляет остановленный поток
        }
    }
}
