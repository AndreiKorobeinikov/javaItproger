package Lections.OtherClassesAndOther;

import java.io.Serializable;

public class L3Course implements Serializable {//Serializable указывает, что объект может быть сериализирован
    //По сути, сериализация-это сохранение объектов в текстовом формате
    private String title;
    private transient int id;//transient указывает, что данное поле не будет серализироваться
    public L3Course(int id,String title){
        this.title = title;
        this.id = id;
    }
    public String toString(){
        return id+" - "+title;
//        return String.valueOf(id);//valueOf позволяет изменить тип данных
    }
    @Override
    public boolean equals(Object object){
        L3Course course = (L3Course) object;//Чтобы корректно работало, создаем объект и образуем его в нужный нам класс
        return id==course.id;//переписали метод сравнения из базового класса Object, чтобы сравнивать айди
    }
}
