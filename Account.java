import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private int balance = 0;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount, String date) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    public void withdraw(int amount, String date) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");

        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    public void printStatement() {
        System.out.println("DATE       | AMOUNT | BALANCE");

        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        for (Transaction t : reversed) {
            System.out.println(t.date + " | " + t.amount + " | " + t.balanceAfter);
        }
    }

    private static class Transaction {
        String date;
        int amount;
        int balanceAfter;

        public Transaction(String date, int amount, int balanceAfter) {
            this.date = date;
            this.amount = amount;
            this.balanceAfter = balanceAfter;
        }
    }
}
