package HomeTasks.SideClasses;

public class Dog extends Animal{
    @Override
    void makeSound() {
        System.out.println("Собачка делает Гаф");
    }

    @Override
    void move() {
        System.out.println("Собачка крадется");
    }
}
