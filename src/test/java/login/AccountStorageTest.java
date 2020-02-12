package login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountStorageTest {
    AccountStorage accountStorage = new AccountStorage();
    @Test
    void shouldReturnTrueIfAccountExits() {

        boolean expected = accountStorage.check("123-4567","password");

        Assertions.assertTrue(expected);
    }

    @Test
    void shouldReturnTrueIfAccountNotExits() {

        boolean expected = accountStorage.check("123-4567","PASS");

        Assertions.assertFalse(expected);
    }
}