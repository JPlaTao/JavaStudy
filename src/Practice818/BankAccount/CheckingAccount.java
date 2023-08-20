package Practice818.BankAccount;

public class CheckingAccount extends BankAccount {
    private double overdraftFee = 500;

    @Override
    public void withdraw(double amount) {
        if (amount > (super.getBalance() + overdraftFee)) {
            System.out.println("取款失败，余额与透支额度均不足，剩余余额：" + super.getBalance()
                    + "，剩余透支额度：" + overdraftFee);
        } else if (amount > super.getBalance() && amount < (super.getBalance() + overdraftFee)) {
            setBalance(0.0);
            overdraftFee -= (amount - super.getBalance());
            System.out.println("取款成功，余额不足，已使用透支额度,剩余额度：" + overdraftFee);
            showInfo();
        } else {
            super.withdraw(amount);
            System.out.println("取款成功");
            showInfo();
        }
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("当前透支额度：" + overdraftFee);
    }
}
