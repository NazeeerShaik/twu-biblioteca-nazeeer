import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class AccountInformation {
    private final Map<String, List> accountInformation = new HashMap<>();

    AccountInformation() {
        accountInformation.put("123-4567", asList("Nazeer", "nazeer@thoughtworks.com", "9381445319"));
        accountInformation.put("765-4321", asList("Teja", "teja@thoughtworks.com", "123456789"));

    }

    public void view(String libraryNumber) {
        if (accountInformation.containsKey(libraryNumber))
            System.out.println(accountInformation.get(libraryNumber).toString());
    }
}
