import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //Requires: amount>=0, account is "Checking" or "Saving"
    //Modifies: this, amount, date, account
    //Effects: create a new Withdraw object
    //         initialize the fields of the object
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: return the string representation of this withdraw
    public String toString(){
        //your code here
        return "Withdraw of: $" + amount + " Date: " + date.toString() + " from account: " + account;
    }
}
