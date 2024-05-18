package Lections.ThreadVariants;

import java.io.IOException;

public class L3App {
    private int count= 0;
    public synchronized void increment(){//synchronized ОзначаетБ что функция синхронизируется между потоками
        count++;
    }
    public static void main(String[] args){
        L3App app = new L3App();
        app.doSomething();
    }
    public void doSomething(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<1000;i++) {
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<1000;i++) {
                    increment();
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
        System.out.println("Результат: "+ count);
    }
}
