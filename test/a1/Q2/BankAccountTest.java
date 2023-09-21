
package a1.Q2;

import org.junit.Test;
import static org.junit.Assert.*;


public class BankAccountTest {
    
     @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(1, 1000.0);
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }
    
     @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(1, 1000.0);
        boolean success = account.withdraw(500.0);
        assertTrue(success);
        assertEquals(500.0, account.getBalance(), 0.001);
    }
}