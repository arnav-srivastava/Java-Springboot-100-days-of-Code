package GenericsEx;

public class Box<T> {

    private T item;


    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                '}';
    }

    public static void main(String[] args) {
        //Setting Integer Type
        Box<Integer> b= new Box<>(25);
        System.out.println(b.getItem());

        //Setting String Type
        Box<String> b1=  new Box<>("This is string");
        System.out.println(b1.getItem());
    }
}
