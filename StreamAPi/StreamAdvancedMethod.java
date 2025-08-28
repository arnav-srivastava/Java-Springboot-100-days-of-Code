package StreamAPi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAdvancedMethod {
    public static void main(String[] args) {

        //collect()
        List<String> name= Arrays.asList("Arnav", "John","Varun");
        List<String> nameUp = name.stream()
                                .map(n -> n.toUpperCase())
                                .collect(Collectors.toList());
        System.out.println(nameUp);


        //groupingBy() - same as SQL Group BY
        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot");
        Map<Character, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(grouped);


        // Parallel stream -Calculates total sum using multiple threads in parallel.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum1 = numbers.parallelStream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("\nTotal Salary (calculated in parallel): $" + sum1);
    }
}
