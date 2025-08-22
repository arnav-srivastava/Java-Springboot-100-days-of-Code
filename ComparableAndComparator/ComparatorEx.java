package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {
    public static void main(String[] args) {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                // custom sort based on last digit of number
                if(i%10 > j%10) return 1;
                else
                    return -1;
            }
        };

        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(29);
        nums.add(92);

        Collections.sort(nums, com);

        System.out.println(nums);
    }

}
