package a1;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        SavingAccount saver1 = new SavingAccount(2000.00f);
        SavingAccount saver2 = new SavingAccount(3000.00f);
        SavingAccount.modifyInterestRate(4/100f);
        for(int month = 1; month <= 12; month++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.println("saver1 Balance:" + saver1.getSavingsBalance() + "\t\tsaver2 Balance:" + saver2.getSavingsBalance());
        SavingAccount.modifyInterestRate(5/100f);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("saver1 Balance:" + saver1.getSavingsBalance() + "\t\t\tsaver2 Balance:" + saver2.getSavingsBalance());
    }
}
