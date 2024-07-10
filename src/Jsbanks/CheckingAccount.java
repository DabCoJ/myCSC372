package Jsbanks;

public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount() {
        super();
        this.interestRate = 9.0;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void processWithdrawal(double amount) {
        super.withdrawal(amount + 60);
        System.out.println("Withdrawal processed with a $30 overdraft fee.");
    }

    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

