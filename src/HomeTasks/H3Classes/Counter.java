package HomeTasks.H3Classes;

public class Counter implements Runnable {
    public static int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0;i<10000;i++){
            count++;
        }
    }
}
