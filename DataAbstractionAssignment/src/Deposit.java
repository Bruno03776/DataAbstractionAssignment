import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //Requires: amount>=0, account is "Checking" or "Saving"
    //Modifies: this, amount, date, account
    //Effects: create a new Deposit object
    //         initialize the fields of the object
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: return the string representation of this deposit
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date.toString() + " into account: " + account;
    }
}
