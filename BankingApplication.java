import java.util.HashMap;

// Custom Exception: Account Not Found
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}

// Custom Exception: Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class BankingApplication {

    private HashMap<Integer, Double> accounts = new HashMap<>();

    // Add account for testing
    public void addAccount(int accNo, double balance) {
        accounts.put(accNo, balance);
    }

    // Deposit Method
    public void deposit(int accNo, double amount) throws AccountNotFoundException {
        if (!accounts.containsKey(accNo))
            throw new AccountNotFoundException("Account not found!");

        accounts.put(accNo, accounts.get(accNo) + amount);
        System.out.println("Deposited ₹" + amount + " into Account " + accNo);
    }

    // Withdrawal Method
    public void withdraw(int accNo, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {

        if (!accounts.containsKey(accNo))
            throw new AccountNotFoundException("Account not found!");

        double balance = accounts.get(accNo);

        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance!");

        accounts.put(accNo, balance - amount);
        System.out.println("Withdrawn ₹" + amount + " from Account " + accNo);
    }

    // Display All Accounts
    public void displayAccounts() {
        System.out.println("\n=== All Account Details ===");
        for (Integer accNo : accounts.keySet()) {
            System.out.println("Account No: " + accNo + " | Balance: ₹" + accounts.get(accNo));
        }
    }

    public static void main(String[] args) {
        BankingApplication bank = new BankingApplication();

        bank.addAccount(101, 5000);
        bank.addAccount(102, 3000);

        try {
            bank.deposit(101, 1000);
            bank.withdraw(102, 2000);
            bank.withdraw(102, 2000);  // This will throw exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        bank.displayAccounts();
    }
}
