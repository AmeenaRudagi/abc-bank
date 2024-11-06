package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account a) {
        String s = "";

       //Translate to pretty account type
        switch(a.getAccountType()){
            case Account.CHECKING:
                s += "Checking Account\n";
                break;
            case Account.SAVINGS:
                s += "Savings Account\n";
                break;
            case Account.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;
            case Acccount.SUPER_SAVINGS:
                s+= "Super Savings Account\n";
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {
            s += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }

    /*
    * method to transfer funds to customer's another account
    */
    public Boolean transferFunds(Account fromAccount,Acccount toAccount,double amount){
           try{
                Boolean isAccountsBelongtoCustomer = checkIfAccountBelongs(fromAccount,toAccount);
                
                if(isAccountsBelongtoCustomer){
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    return true; 
                }
                else{
                    return false;
                }
           } catch(IllegalArgumentException ex){
                    //log the error
                    return false;
            }
    }

    private Boolean checkIfAccountBelongs(Account fromAccount,Account toAccount){
        if(fromAccount.getNumberOfAccounts > 1){
            if(fromAccount.getName().equalsIgnoreCase(toAccount.getName())){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }
    }
}
