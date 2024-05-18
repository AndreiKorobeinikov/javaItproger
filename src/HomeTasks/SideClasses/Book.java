package HomeTasks.SideClasses;

import Lections.Genre;

public class Book {
    protected static String title, author;
    protected static short year;
    protected Genre genre;
    public Book(String title, String author, short year){
        this.title = title;
        this.author = author;
        this.year = year;
    }
    protected Book(String title, String author, short year, Genre genre){
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        // ввод нового типа данных в конструктор
    }
    public void displayInfo(){
        System.out.println("Книга "+title+" за авторством "+author+" была выпущена в "+year+" году");
    }
}
