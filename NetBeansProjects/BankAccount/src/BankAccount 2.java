
public class BankAccount {

    BankAccount(String name) {
        accountName = name;
    }

    private long balance; //pennies
    private String accountName; //arbitrary name

    public boolean withdraw(double debit) {
        if (getBalance() >= debit) { //if credit does not exceed current balance
            setBalance(getBalance() - debit);// subtracting debit (dollars) from getBalance (dollars) and converting back to pennies
            return true;
        } else {
            System.out.println("Can't do it");// program won't withdraw anything if debit exceeds balance
            return false;
        }
    }

    public void deposit(double credit) {
        setBalance(getBalance() + credit);  //adds credit (dollars) to balance (dollars) and converts to pennies
    }

    public double getBalance() {
        return balance / 100.0;  //pennies to dollars
    }

    public String getAccountName() {
        return accountName; //returns a name 
    }

    private void setBalance(double newBalance) {// inputs in dollars 
        balance = (long) (newBalance * 100.0);// converts to pennies
    }
}
