import java.util.Date;

public class Main {

    static double depositChecking(double amt){
        // create a customer
        Customer customer = new Customer("ABC", 123, 10, 20);
        // deposit amt to the checking account
        double balance = customer.deposit(amt, new Date(), "Checking");
        // return the balance
        return balance;
    }

    static double depositSaving(double amt){
        // create a customer
        Customer customer = new Customer("ABC", 123, 10, 20);
        // deposit amt to the checking account
        double balance = customer.deposit(amt, new Date(), "Saving");
        // return the balance
        return balance;
    }

    static double withdrawChecking(double amt){
        // create a customer
        Customer customer = new Customer("ABC", 123, 10, 20);
        // withdraw amt from the checking account
        double balance = customer.withdraw(amt, new Date(), "Checking");
        // return the balance
        return balance;
    }

    static double withdrawSaving(double amt){
        // create a customer
        Customer customer = new Customer("ABC", 123, 10, 20);
        // withdraw amt from the checking account
        double balance = customer.withdraw(amt, new Date(), "Saving");
        // return the balance
        return balance;
    }

    public static void main(String[] args) {

    }
}
