import java.util.Scanner;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void transfer(double amount, Account receiver) {
        if (amount <= balance) {
            balance -= amount;
            receiver.deposit(amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

public class ATMInterface1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(1000); // Starting balance of $1000

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposited $" + depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter receiver's balance: ");
                    double receiverBalance = scanner.nextDouble();
                    Account receiver = new Account(receiverBalance);
                    account.transfer(transferAmount, receiver);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
