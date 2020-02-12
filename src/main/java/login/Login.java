package login;

public class Login {
    private String libraryNumber;
    private String password;
    private AccountStorage accountStorage = new AccountStorage();
    private AccountInformation accountInformation = new AccountInformation();

    public Login(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean verify() {
        return accountStorage.check(this.libraryNumber, this.password);
    }

    public void viewInformation() {
        if (verify()) accountInformation.view(this.libraryNumber);
    }
}
