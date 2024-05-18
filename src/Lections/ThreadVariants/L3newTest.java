package Lections.ThreadVariants;

public class L3newTest implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i <= 128; i*=2) {
            System.out.println("Элемент 2: " + i);
        }
    }
}
