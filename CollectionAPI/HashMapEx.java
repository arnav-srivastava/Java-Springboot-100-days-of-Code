package CollectionAPI;

import java.util.HashMap;
import java.util.Map;



public class HashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<>();
        map.put("User 1", 1234567890);
        map.put("User 2", 549841584);
        map.put("User 3", 544181498);
        map.put("User 4", 565884598);
        map.put("User 5", 987456312);
        map.put("User 1", 123456789); // duplicate key value updated

        System.out.println(map.get("User 1"));

        System.out.println(map.containsKey("User 3"));

        System.out.println(map.containsValue(123456789));

        System.out.println(map.size());

        map.remove("User 4");
        System.out.println(map);

        map.replace("User 2",888899997);

        System.out.println("Check empty or not "+map.isEmpty());

        System.out.println("All Values "+map.values());

        System.out.println("All keys "+map.keySet());

        for (String user: map.keySet()){
            System.out.println(user+ " "+map.get(user));
        }

    }
}
