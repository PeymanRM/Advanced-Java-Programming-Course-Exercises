package a1;

/**
 * Created by Peyman RM
 */
public class SavingAccount {
    private static float annualInterestRate;
    private float savingsBalance;

    public SavingAccount(float savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest(){
        savingsBalance += savingsBalance*annualInterestRate/12;
    }

    public static void modifyInterestRate(float newInterestRate){
        annualInterestRate = newInterestRate;
    }

    public float getSavingsBalance() {
        return savingsBalance;
    }
}
