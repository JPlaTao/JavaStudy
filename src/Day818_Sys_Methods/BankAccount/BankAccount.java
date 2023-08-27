package Day818_Sys_Methods.BankAccount;

public class BankAccount {
    private static int accountNumber;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(int accountNumber, double balance) {
        BankAccount.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }

    public void showInfo(){
        System.out.printf("账户号:%s,当前余额：%s。\n",accountNumber,balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        BankAccount.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
