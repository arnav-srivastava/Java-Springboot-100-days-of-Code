package OptionalClass;

import java.util.Optional;

public class OptionalClassEx {
    public static void main(String[] args) {
        String[] names=new String[10];

        Optional<String> getName = Optional.ofNullable(names[3]);

        if(getName.isPresent()){
            String name= names[3].toLowerCase();
            System.out.println(name);
        }
        else{
            System.out.println("Name is null/empty");
        }
    }
}
