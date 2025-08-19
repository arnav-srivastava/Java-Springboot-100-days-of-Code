package OOP;
interface Payment{
    void pay(double amount);
}

class DebitCardPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Amount paid using debit card "+amount);
    }
}
public class InterfaceEx {
    public static void main(String[] args) {
        Payment p=new DebitCardPayment();
        p.pay(5000);
    }
}
