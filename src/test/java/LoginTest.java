import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginTest {
    @Test
    void shouldReturnTrueIfLoginIsSuccess() {
        Login login = new Login("123-4567", "password");

        Assertions.assertTrue(login.submit());

    }

    @Test
    void shouldReturnFalseIfLoginIsUnSuccess() {
        Login login = new Login("123-4567", "PASS");

        boolean expected = login.submit();

        Assertions.assertFalse(expected);
    }
}