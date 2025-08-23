package ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryCatch {
    public static void main(String[] args) {

        // try-catch-finally example
        try{
            int i=10/0;
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero "+e.getMessage());
        }
        finally {
            System.out.println("Finally execution completed");
        }

        //checked exception at compile time
        try{
            FileReader rd=new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //unchecked exception at runtime
        String text = null;
        System.out.println(text.length());

    }
}
