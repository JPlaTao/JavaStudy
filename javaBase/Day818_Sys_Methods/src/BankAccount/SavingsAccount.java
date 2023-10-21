package BankAccount;

public class SavingsAccount extends BankAccount {
    private double interestRate = 0.03;

    public SavingsAccount() {
    }

    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBalance() - amount < 0) {
            showInfo();
            System.out.println("取款失败，请保留0以上的余额");
        }
        else {
            super.withdraw(amount);
            System.out.println("取款成功");
            showInfo();
        }
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("当前利率："+ interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}
