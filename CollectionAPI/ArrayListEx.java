package CollectionAPI;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
    public static void main(String[] args) {
        List<String> al=new ArrayList<>();

        al.add("apple");
        al.add("mango");
        al.add("grapes");
        al.add("banana");
        al.add("apple"); //duplicates allowed

        System.out.println("Element at index 2 "+ al.get(2));

        // update the list
        al.set(1,"Orange");


        al.remove(3);
        al.remove("apple");

        System.out.println(al.contains("apple"));

        System.out.println(al.size()); // get the size of the list

        // traverse full list
        for (String fruit: al){
            System.out.println(fruit);
        }
        System.out.println(al.isEmpty()); // check empty
    }
}
