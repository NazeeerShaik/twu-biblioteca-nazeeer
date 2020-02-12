package login;

import java.util.Objects;

public class Account {
    private String libraryNumber;
    private String password;

    public Account(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return libraryNumber.equals(account.libraryNumber) &&
                password.equals(account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }
}
