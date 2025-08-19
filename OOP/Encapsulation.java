package OOP;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    //Getter
    public double getBalance() {
        return balance;
    }
    //Setter
    public void deposit(double amount) {
        if(amount>0){
            balance+=amount;
        }
    }
    public void withdraw(double amount){
        if(amount>0 && balance>=amount){
            balance-=amount;
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount account=new BankAccount(2000);
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Account Balance "+ account.getBalance());

    }
}
