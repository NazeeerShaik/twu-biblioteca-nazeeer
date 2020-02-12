package login;
//TODO: TEST
import java.util.ArrayList;
import java.util.List;

public class AccountStorage {
    private List<Account> accounts = new ArrayList<>();

    public AccountStorage() {
        accounts.add(new Account("123-4567", "password"));
        accounts.add(new Account("765-4321", "PASS"));
    }

    public boolean check(String libraryNumber, String password) {
        Account loginAccount = new Account(libraryNumber, password);
        for (Account account : accounts) {
            if (account.equals(loginAccount)) return true;
        }
        return false;
    }
}
