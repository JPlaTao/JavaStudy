package E2_BankAccount;

public abstract class BankAccount {
    String accountNumber;
    double balance;

    abstract double withdraw(double amount);

    abstract double deposit(double amount);


}

class SavingAccount extends BankAccount {

    @Override
    double withdraw(double amount) {
        balance -= amount;
        return balance;
    }

    @Override
    double deposit(double amount) {
        balance += amount;
        return balance;
    }
}

class CheckingAccount extends BankAccount {

    private double overDraftLimit = 200;

    @Override
    double withdraw(double amount) {
        if (amount <= balance) return balance -= amount;
        if (amount <= balance + overDraftLimit) {
            balance = 0;
            overDraftLimit = overDraftLimit - (amount - balance);
            return overDraftLimit;
        } else
            return -1;
    }

    @Override
    double deposit(double amount) {
        return 0;
    }
}