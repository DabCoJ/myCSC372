package Jsbanks;

public class Test {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        account.setFirstName("John");
        account.setLastName("Smith");
        account.setAccountID(548274926);
        account.deposit(1250000.0);
        account.withdrawal(200301.0);

        System.out.println("Bank Account Summary:");
        account.accountSummary();
        System.out.println();

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setFirstName("Jane");
        checkingAccount.setLastName("Smith");
        checkingAccount.setAccountID(830552667);
        checkingAccount.deposit(50300.0);
        checkingAccount.processWithdrawal(74001.0);
        checkingAccount.setInterestRate(9.5);

        System.out.println("Checking Account Summary:");
        checkingAccount.displayAccount();
    }
}

