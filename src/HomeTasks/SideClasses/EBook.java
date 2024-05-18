package HomeTasks.SideClasses;

import Lections.Genre;

public class EBook extends Book{
    private static String fileType;
    public EBook(String title, String author, short year,String fileType) {
        super(title, author, year);
        this.fileType = fileType;
    }
    public EBook(String title, String author, short year, String fileType,Genre genre){
        // ввод нового типа данных в конструктор
        super(title,author,year,genre);
        this.fileType = fileType;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Этo-электронная книга формата "+ fileType);
    }
    public void displayGenre(){
        System.out.println("Эта книга жанра "+ genre);
        // использование нового типа данных в методах
    }
}
