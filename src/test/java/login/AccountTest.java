package login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void shouldCompareTwoAccountObjects() {
        Account account = new Account("123","pass");

        Assertions.assertEquals(new Account("123","pass"),account);
    }

    @Test
    void shouldReturnFalseTwoAccountObjectsAreDifferent() {
        Account account = new Account("123","pass");

        Assertions.assertNotEquals(new Account("123","password"),account);
    }
}
