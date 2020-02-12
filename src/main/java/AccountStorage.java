import java.util.ArrayList;
import java.util.List;

public class AccountStorage {
    List<Account> accountList = new ArrayList<>();

    AccountStorage() {
        accountList.add(new Account("123-4567", "password"));
        accountList.add(new Account("765-4321", "PASS"));
    }

    public boolean check(String libraryNumber, String password) {
        Account loginAccount = new Account(libraryNumber, password);
        for (Account account : accountList) {
            if (account.equals(loginAccount)) return true;
        }
        return false;
    }
}
