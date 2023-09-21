package a1.Q2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM(10); // Maximum of 10 accounts

        // Create and add accounts
        BankAccount account1 = new BankAccount(1, 1000.0);
        BankAccount account2 = new BankAccount(2, 1500.0);
        atm.addAccount(account1);
        atm.addAccount(account2);

        Scanner scanner = new Scanner(System.in);
        int accountNumber;
        BankAccount currentAccount = null;

        while (true) {
            System.out.print("Enter your account number (0 to exit): ");
            accountNumber = scanner.nextInt();

            if (accountNumber == 0) {
                break;
            }

            currentAccount = atm.findAccount(accountNumber);

            if (currentAccount == null) {
                System.out.println("Account not found.");
            } else {
                break;
            }
        }

        if (currentAccount != null) {
            while (true) {
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Balance: $" + currentAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        currentAccount.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                        break;
                    case 3:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        boolean success = currentAccount.withdraw(withdrawAmount);
                        if (success) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient funds or invalid amount.");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
}
