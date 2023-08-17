package Practice816;

public class Q2BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Q2BankAccount() {

    }

    public Q2BankAccount(int accountNumber, String accountHolder) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public void showInfo(){
        System.out.printf("账号%s，持有人：%s，余额：%s。\n",
                this.accountNumber,this.accountHolder,this.balance);
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

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;
        System.out.println("存入"+amount+",当前余额："+balance);
    }

    public void withdrawal(double amount){
        this.balance -= amount;
        System.out.println("取出"+amount+",当前余额："+balance);
    }

}
