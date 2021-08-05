
import java.util.ArrayList;
import java.util.Collection;

public class Bank { 
    public Bank() {  //constructor
        accounts = new ArrayList<>();  
    }
    private Collection<BankAccount> accounts;  //field creating collection of Bankacounts

   

    private BankAccount findAccount(String name) {
        for (BankAccount acct : accounts) { //goes through each BA in the collection of bankaccounts
            if (acct.getAccountName().equals(name)) {  //if name of one account equals inputted name
                return acct;  //return reference to the account
            }
        }
        return null;  //else return nothing [account doesn't exist]
    }

    public boolean openAccount(String name) {
        BankAccount acct = findAccount(name);  //acct is reference to the account with the same inputted name
        if (acct == null) {  //if acct doesn't exist
            accounts.add(new BankAccount(name));  //add new account to collection with inputted name
            return true;
        }
        return false;
    }

    public double closeAccount(String name) {
        BankAccount acct = findAccount(name);  //acct is reference to the account with the same inputted name
        if (acct != null) {  //if account exists
            accounts.remove(acct);  //remove account from collection
            return acct.getBalance();  //get its balance
        }
        return -1.0;  //if it doesn't exist return -1.0
    }

    public double getBalance(String name) {
        BankAccount acct = findAccount(name); //acct is reference to the account with the same inputted name
        if (acct != null) {  //if account exists
            return acct.getBalance();  //return its balance
        }
        return -1.0; //invalid balance
    }

    public void deposit(String name, double credit) {
        BankAccount acct = findAccount(name);  //acct is reference to the account with the same inputted name
        if (acct != null) {  //if accounts exists
            acct.deposit(credit); //deposit credit value to account with specified name
        }
    }

    public boolean withdraw(String name, double debit) {
        BankAccount acct = findAccount(name); //acct is reference to the account with the same inputted name
        if (acct!=null) {  //if account exists
            acct.withdraw(debit); //withdraw value of debit from account with specified name
        }
        return false;
    }

    public boolean transfer(String donnor, String recipient, double amount) {
        BankAccount from = findAccount(donnor);  //from is reference to the account with the same inputted name
        BankAccount to = findAccount(recipient);  //to is reference to the account with the same inputted name

        if (from != null && to!=null) { //if from and to are accounts that exist
            from.withdraw(amount);  //take value of amount from the from account
            to.deposit(amount); //add it to the to account
        }
        return false;
    }

    public double getTotalAssets() {
        double i = 0;
        for(BankAccount acct : accounts) {  //goes through each BA in collection of BA
            i += acct.getBalance();  //adds Balance of each account together and stores it in variable i
        }
        return i;  //returns value of i
    }

}
