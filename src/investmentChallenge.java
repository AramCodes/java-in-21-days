public class investmentChallenge {

    static int initialInvestment = 14_000;
    static float firstYearGrowth = 1.40F;
    static int secondYearLost = 1_500;
    static float thirdYearGrowth = 1.12F;

    static int balance;


    public static void main(String[] args) {
        System.out.println("You made an initial investment of " + initialInvestment);

        System.out.println("After your first year your investment grew to " + initialInvestment * firstYearGrowth);
            balance = (int) (initialInvestment * firstYearGrowth);

        System.out.println("After your second year your invest lost " + secondYearLost);
            balance = balance - secondYearLost;

        System.out.println("After your third year add another 12% and grew to " + balance * thirdYearGrowth);
            balance = (int) (balance * thirdYearGrowth);
    }
}
