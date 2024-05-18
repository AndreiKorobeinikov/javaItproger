package HomeTasks;

import HomeTasks.H3Classes.Counter;

import static HomeTasks.H3Classes.Counter.count;

public class H3 {
    public static void main(String[] args){
        Counter counter = new Counter();
        Thread count1 = new Thread(counter);
        Thread count2 = new Thread(counter);
        count1.start();
        count2.start();
        try {
            count1.join();
            count2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
