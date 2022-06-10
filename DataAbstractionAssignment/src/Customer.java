import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
    }

    //Requires: accountNumber>=0, checkDeposit>=OVERDRAFT and savingDeposit>=OVERDRAFT
    //Modifies: this, name, accountNumber, checkDeposit, savingDeposit, deposits and withdraws
    //Effects: create a new Customer object
    //         initialize the fields of the object
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        //initialize the fields
        this.name = name;
        this.accountNumber = accountNumber;
        checkBalance = checkDeposit;
        savingBalance = savingDeposit;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
    }

    //Requires: amt>=0, account is "Checking" or "Saving"
    //Modifies: this, deposits, checkDeposit and savingDeposit
    //Effects: add a Deposit object to deposits
    //         add amt to the balance of account
    //         returns balance of account
    public double deposit(double amt, Date date, String account){
        //your code here
        //create a deposit object and add it to the deposits ArrayList
        Deposit deposit = new Deposit(amt, date, account);
        deposits.add(deposit);
        //apply the deposit to the corresponding account and return the balance
        if(account.equals(CHECKING)) {
            checkBalance += amt;
            return checkBalance;
        }
        else {
            savingBalance += amt;
            return savingBalance;
        }
    }

    //Requires: amt>=0, account is "Checking" or "Saving"
    //Modifies: this, withdraws, checkDeposit and savingDeposit
    //Effects: add a Withdraw object to withdraws
    //         deduct amt from the balance of account if no overdraft
    //         return balance of account
    public double withdraw(double amt, Date date, String account){
        //your code here
        //check if the account is overdraft after withdrawing amt
        if(checkOverdraft(amt, account)) {
            //return the current balance of the corresponding account
            if(account.equals(CHECKING)) {
                return checkBalance;
            }
            else {
                return savingBalance;
            }
        }
        else {
            //create a withdraw object and add it to the withdraws ArrayList
            Withdraw withdraw = new Withdraw(amt, date, account);
            withdraws.add(withdraw);
            //apply to the withdraw to the corresponding account and return the balance
            if(account.equals(CHECKING)) {
                checkBalance -= amt;
                return checkBalance;
            }
            else {
                savingBalance -= amt;
                return savingBalance;
            }
        }
    }

    //Requires: amt>=0, account is "Checking" or "Saving"
    //Modifies: nothing
    //Effects: return if the account will overdraft after withdrawing amt
    private boolean checkOverdraft(double amt, String account){
        //your code here
        //check if the withdraw is from the checking account and if it will cause overdraft
        if(account.equals(CHECKING) && checkBalance - amt <= OVERDRAFT) {
            return true;
        }
        //check if the withdraw is from the saving account and if it will cause overdraft
        if(account.equals(SAVING) && savingBalance - amt <= OVERDRAFT) {
            return true;
        }
        return false;
    }

    //do not modify
    //Requires: nothing
    //Modifies: nothing
    //Effects: print all Deposit objects stored in deposits
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    //do not modify
    //Requires: nothing
    //Modifies: nothing
    //Effects: print all Withdraw objects stored in withdraws
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
