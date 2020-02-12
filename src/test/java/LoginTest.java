import login.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LoginTest {
    @Test
    void shouldReturnTrueIfLoginIsSuccess() {
        Login login = new Login("123-4567", "password");

        Assertions.assertTrue(login.verify());

    }

    @Test
    void shouldReturnFalseIfLoginIsUnSuccess() {
        Login login = new Login("123-4567", "PASS");

        boolean expected = login.verify();

        Assertions.assertFalse(expected);
    }

    @Test
    void shouldDisplayInformationIfLoginIsSuccessO() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Login login = new Login("123-4567", "password");

        login.viewInformation();

        verify(out).println("[Nazeer, nazeer@thoughtworks.com, 9381445319]");
    }
}