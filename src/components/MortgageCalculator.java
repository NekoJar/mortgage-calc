package components;

public class MortgageCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principalValue;
    private float annualInterestRate;
    private byte period;

    public MortgageCalculator(int principalValue, float annualInterestRate, byte period){
        this.principalValue = principalValue;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }
  
    public double calculateMortgage(){

        float numberOfPayments = getNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterest();

        double mortgageCalc = principalValue * ( monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1 ));

        return mortgageCalc;
    }

    public double calculateRemains(short numberOfPaymentsMade){

        float numberOfPayments = getNumberOfPayments();
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        double remainsCalc = principalValue * ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - (Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))) / (Math.pow(1 + monthlyInterestRate, numberOfPayments)-1);
        
        return remainsCalc;
    }

    public double[] getRemainingBalance(){
        var balances = new double[getNumberOfPayments()];
        for(short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateRemains(month);
        return balances;
    }

    private float getMonthlyInterest(){
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return period * MONTHS_IN_YEAR;
    }
}
