package a1.Q2;

import java.util.Scanner;

class ATM {

    private BankAccount[] accounts;
    private int numberOfAccounts;

    public ATM(int maxAccounts) {
        accounts = new BankAccount[maxAccounts];
        numberOfAccounts = 0;
    }

    public void addAccount(BankAccount account) {
        if (numberOfAccounts < accounts.length) {
            accounts[numberOfAccounts] = account;
            numberOfAccounts++;
        }
    }

    public BankAccount findAccount(int accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }
}
