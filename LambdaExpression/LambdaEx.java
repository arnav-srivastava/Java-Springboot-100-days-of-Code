package LambdaExpression;

 @FunctionalInterface
interface Greeting{
    void greet(String name);
}

public class LambdaEx {
    public static void main(String[] args) {

        // Traditional way
        Greeting g1=new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("hello "+ name);
            }
        };
        g1.greet("Arnav");


        //Using lambda expression
        Greeting g2 = (name) -> System.out.println("hello "+ name);
        g2.greet("User");
    }
}
