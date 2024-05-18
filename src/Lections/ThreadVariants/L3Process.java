package Lections.ThreadVariants;

public class L3Process extends Thread{
    private volatile boolean isRun = true;//volatile значит, что при использовании в потоках эта переменная не попадает в кэш
    public void run(){
        while (isRun){
            System.out.println("Привет!");
            try {
                Thread.sleep(2000);//программа будет останавливаться каждые 200 миллисекунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void exit(){
        isRun = false;
    }
}
