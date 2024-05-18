package Lections.ThreadVariants;

public class L3Elements extends Thread{
    @Override
    public void run(){
        for (int i = 0; i<=10;i++){
            System.out.println("Элемент 1: "+i);
        }
    }
}
