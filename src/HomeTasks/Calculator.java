package HomeTasks;

public class Calculator {

    class Operation{
        private int a,b;

        void multiply(int a, int b){
            this.a = a;
            this.b = b;
            System.out.println("Результат умножения "+a+" и "+b+" равен "+ (a*b));
        }
         void add(int a, int b){
            System.out.println("Результат сложения "+a+" и "+b+" равен "+ (a+b));
        }
    }
    Operation operation = new Operation();
}
