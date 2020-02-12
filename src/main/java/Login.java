public class Login {
    private String libraryNumber;
    private String password;
    private AccountStorage accountStorage = new AccountStorage();

    public Login(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean submit() {
        return accountStorage.check(this.libraryNumber, this.password);
    }
}
