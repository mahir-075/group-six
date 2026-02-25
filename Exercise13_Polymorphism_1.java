
/**
 * Write a description of class BankAccount here.
 *
 * @author (Hassan Juma Said)
 * @version (12-02-2026)
 */
/**
 * Exercise 13: Polymorphism - Banking System
 * PT821 - Object-Oriented Programming
 * State University of Zanzibar (SUZA)
 *
 * Complete implementation of a polymorphic banking system.
 */

class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited TZS %.2f. New balance: TZS %.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.printf("Withdrew TZS %.2f. New balance: TZS %.2f%n", amount, balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance: TZS %.2f%n", balance);
    }

    public double calculateInterest() {
        return 0.0;
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 10000) {
            balance -= amount;
            System.out.printf("Withdrew TZS %.2f. New balance: TZS %.2f%n", amount, balance);
        } else {
            System.out.println("Withdrawal denied: Minimum balance of TZS 10,000 required.");
        }
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.printf("Interest of TZS %.2f applied. New balance: TZS %.2f%n", interest, balance);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Savings");
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.printf("Withdrew TZS %.2f (overdraft used). New balance: TZS %.2f%n", amount, balance);
        } else {
            System.out.println("Withdrawal denied: Exceeds overdraft limit.");
        }
    }

    @Override
    public double calculateInterest() {
        return 0.0;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Current");
        System.out.printf("Overdraft Limit: TZS %.2f%n", overdraftLimit);
        System.out.println("Overdrawn: " + (isOverdrawn() ? "Yes" : "No"));
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private int maturityMonths;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, String accountHolder, double balance,
                               double interestRate, int maturityMonths) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.maturityMonths = maturityMonths;
        this.isMatured = false; // initially not matured
    }

    @Override
    public double calculateInterest() {
        // interest for the full period
        return balance * interestRate * (maturityMonths / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (!isMatured) {
            System.out.println("Withdrawal denied: Fixed deposit account not yet matured.");
        } else if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.printf("Withdrew TZS %.2f. New balance: TZS %.2f%n", amount, balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkMaturity() {
        isMatured = true;
        System.out.println("Account matured successfully.");
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit");
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
        System.out.println("Maturity Period: " + maturityMonths + " months");
        System.out.println("Matured: " + (isMatured ? "Yes" : "No"));
    }
}

// Bank class (manages multiple accounts)
class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank(int capacity) {
        accounts = new BankAccount[capacity];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Cannot add more accounts: Bank is full.");
        }
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].calculateInterest(); // polymorphic call
        }
        return total;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Account " + (i + 1) + " ---");
            accounts[i].displayAccountInfo();
        }
    }

    // Helper method to find an account by number
    public BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}
// Main class with overloaded transfer methods
public class Exercise13_Polymorphism_1 {

    // Overloaded transfer methods
    public static void transferMoney(BankAccount from, BankAccount to, double amount) {
        transferMoney(from, to, amount, "Transfer");
    }

    public static void transferMoney(BankAccount from, BankAccount to, double amount, String description) {
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
            return;
        }
        // Attempt withdrawal from source
        double originalFromBalance = from.getBalance();
        from.withdraw(amount);
        // Check if withdrawal succeeded (balance changed)
        if (from.getBalance() < originalFromBalance) {
            // Deposit into destination
            to.deposit(amount);
            System.out.println("Transfer completed: " + description);
        } else {
            System.out.println("Transfer failed: Insufficient funds in source account.");
        }
    }

    public static void transferMoney(BankAccount from, String toAccountNumber, double amount, Bank bank) {
        BankAccount to = bank.findAccount(toAccountNumber);
        if (to == null) {
            System.out.println("Transfer failed: Destination account not found.");
            return;
        }
        transferMoney(from, to, amount, "Transfer to account " + toAccountNumber);
    }

    public static void main(String[] args) {
        System.out.println("=== BANKING SYSTEM TEST ===\n");

        // Create different types of accounts
        SavingsAccount savings = new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);
        CurrentAccount current = new CurrentAccount("CUR001", "Fatma Said", 1000000, 500000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Omar Juma", 2000000, 0.08, 12);

        // Test deposit and withdrawal for each account type
        System.out.println("--- Testing Savings Account ---");
        savings.displayAccountInfo();
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();
        System.out.println("Interest earned: TZS " + savings.calculateInterest());
        savings.displayAccountInfo();

        System.out.println("\n--- Testing Current Account ---");
        current.displayAccountInfo();
        current.withdraw(1200000);  // Should use overdraft
        System.out.println("Is overdrawn? " + current.isOverdrawn());
        current.displayAccountInfo();

        System.out.println("\n--- Testing Fixed Deposit ---");
        fixed.displayAccountInfo();
        fixed.withdraw(500000);  // Should fail - not matured
        System.out.println("Maturity amount: TZS " + fixed.getMaturityAmount());

        // Create a Bank and add all accounts
        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);

        // Test polymorphic behavior
        System.out.println("\n--- Bank Summary (Polymorphism) ---");
        bank.displayAllAccounts();
        System.out.printf("Total Deposits: TZS %.2f%n", bank.getTotalDeposits());
        System.out.printf("Total Interest: TZS %.2f%n", bank.getTotalInterest());

        // Test method overloading with transfers
        System.out.println("\n--- Testing Transfers (Overloading) ---");
        transferMoney(savings, current, 50000);
        transferMoney(current, savings, 30000, "Rent payment");
        // Test third overload: transfer from savings to an account number
        transferMoney(savings, "CUR001", 20000, bank);

        System.out.println("\n=== END OF TEST ===");
    }
}