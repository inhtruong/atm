public class Account {
    private String name;
    private int accountBalance;


    public Account() {

    }

    public Account(String name, int accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void addToBalance(int amount) {
            accountBalance += amount;
    }

    public  void subFromBalance(int amount){
        if(amount > accountBalance) {
            System.out.println("So du tai khoan khong du!");
        } else {
            accountBalance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Chu tai khoan: " + getName() + "\nSo du trong tai khoan: " + getAccountBalance();
    }
}
