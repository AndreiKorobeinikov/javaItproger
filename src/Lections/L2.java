package Lections;

import HomeTasks.SideClasses.EBook;
import Lections.OtherClassesAndOther.MyAnnotation;

@MyAnnotation(number = 4, name = "a", digit = 3.4F)
//ВВодим в класс аннотацию
public class L2 {
    @MyAnnotation(name = "g", digit = 4.0F)
//    @Deprecated помогает посметить устаревшие функции. Если постараться их использовать, то они будут зачеркнуты
//    @SuppressWarnings("") позволяет игнорировать предупреждения компилятора о непроверенных методах
    public static void main(@MyAnnotation(name = "j", digit = 0.5F) String[] args){
        //Аннотации можно добавить почти куда угодно, если только не ограничить ее использование при создании
        EBook AnD = new EBook("Angels & Demons","Din Kunz", (short) 2008,".txt",Genre.TRILLER);
        //Тут я создал объект книги по конструктору, который создал в классах Book и EBook, смотри там
        AnD.displayInfo();
        AnD.displayGenre();
    }
}
