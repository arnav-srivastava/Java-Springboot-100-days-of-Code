package StreamAPi;

import java.util.Arrays;
import java.util.List;

public class StreamAPIEx {
    public static void main(String[] args) {

        System.out.println("Filter method demo");
        //Filter Method
        List<Integer> al= Arrays.asList(1,2,3,4,5);
        al.stream().filter(n ->n%2 == 0).forEach(n -> System.out.println(n));


        System.out.println("Map method demo");
        //Map method - transform each element
        List<String> names = Arrays.asList("Arnav", "John", "Aman");
        names.stream()
                .map(name -> name.length())
                .forEach(len -> System.out.println(len));



        System.out.println("Reduce Method demo");
        //Reduce method
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);


    }
}
