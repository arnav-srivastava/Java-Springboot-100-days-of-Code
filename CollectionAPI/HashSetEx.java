package CollectionAPI;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> hs=new HashSet<>();
        hs.add("Car");
        hs.add("Bike");
        hs.add("Truck");
        hs.add("Helicopter");
        hs.add("Car"); // duplicate ignored

        System.out.println(hs);

        System.out.println(hs.contains("Bike"));

        hs.remove("Helicopter");

        System.out.println("Length of set is "+ hs.size());

        for (String vehicle : hs){
            System.out.println(vehicle);
        }

        System.out.println(hs.isEmpty());
    }
}
