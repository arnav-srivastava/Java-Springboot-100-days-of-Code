package OOP;

class Calculator{
    int add(int a, int b){
        return a+b;
    }
    double add(double a, double b){
        return a+b;
    }
}

class Phone {
    void sound() {
        System.out.println("Phone has speaker");
    }
}

class Realme extends Phone {
    // Method Overriding (Runtime Polymorphism)
    @Override
    void sound() {
        System.out.println("Realme sound");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Calculator c=new Calculator();
        System.out.println("Integer add "+c.add(5,10));
        System.out.println("Double add "+c.add(5.5,4.5));

        Phone p=new Realme();
        p.sound();
    }
}
