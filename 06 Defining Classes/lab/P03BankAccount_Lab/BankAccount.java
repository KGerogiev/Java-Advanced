package P03BankAccount_Lab;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;

    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balace;

    BankAccount(){
        this.id = bankAccountCount++;
    }
    static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }
    void deposit(double amount){
        this.balace += amount;
    }

    public int getId() {
        return id;
    }

    double getInterest(int year){
        return BankAccount.interestRate * year * this.balace;
    }
}
