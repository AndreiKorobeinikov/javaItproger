package Lections.OtherClassesAndOther;

public class L3Print<T1> {// создаем класс-generic, в угловых скобках пишем название для типа данных
    //generic- содержимое угловых скобок для указания типа данных коллекции
    private T1 info;
    private String data;
    public void setInfo(T1 info){
        this.info = info;
    }
    public T1 getInfo(){
        return  this.info;
    }
        public <T1,T2> T2 print(T1[] items,T2 info){// при работе с дженериком работаем так
        for (T1 item:items){
            System.out.println(item);
        }
        return info;
    }
}
