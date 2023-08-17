package Practice816;

public class Q2BankAccount {
    private int accountNumber;
    private String accountHolder;
    private int balance;

    public Q2BankAccount() {

    }

    public Q2BankAccount(int accountNumber, String accountHolder, int balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public int getBalance(){
        return this.balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println("存入"+amount+",当前余额："+balance);
    }

    public void withdrawal(int amount){
        this.balance -= amount;
        System.out.println("取出"+amount+",当前余额："+balance);
    }

}
