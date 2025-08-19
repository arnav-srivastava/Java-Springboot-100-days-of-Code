package OOP;

abstract  class Vehicle{
    abstract  void start();

    void speaker(){
        System.out.println("Vehicle has Speaker");
    }
}

class  WagnR extends Vehicle{

    @Override
    void start() {
        System.out.println("WagnR starts with key");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Vehicle v=new WagnR();
        v.start();
        v.speaker();
    }
}
