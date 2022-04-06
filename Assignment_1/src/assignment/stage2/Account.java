package assignment.stage2;

public class Account {
	
	public static final float BROKER_FEE = .0125f;
	public static final float DAYS_OF_THE_YEAR = 365;
	
	public double	loanValue, monthlyRate;	
	public int	daysActive;
	AccountType accountType;
	
	public Account(double loanValue, double monthlyRate, AccountType accountType) throws Exception {
		if(loanValue<0)
			throw new InvalidValueException("The loan value is negative");
		if(monthlyRate < 0) {
			throw new InvalidValueException("The monthly rate has a negative value");
		}
		this.loanValue = loanValue;
		this.monthlyRate = monthlyRate;
		this.accountType = accountType;
	}
	
	
	public double getLoanoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}
	
	public double getMonthlyRate() {
		System.out.println("The rate is "+monthlyRate);
		return this.monthlyRate;
	}
	
	//must have method - the lead has requested it in all classes
	public double calculateMonthlyRate() {
		return loanValue*monthlyRate;
	}
	
	public void setLoanValue(double loanValue) throws InvalidValueException {
		if(loanValue < 0) {
			throw new InvalidValueException("The loan value should be positive");
		}
		this.loanValue = loanValue;
	}
	
	public String getAccountDetails() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("ACCOUNT DETAILS");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("Loan value: ");
		stringBuilder.append(this.loanValue);
		stringBuilder.append("Monthly rate: ");
		stringBuilder.append(this.monthlyRate);
		stringBuilder.append("Days active: ");
		stringBuilder.append(this.daysActive);
		stringBuilder.append("Account type: ");
		stringBuilder.append(this.accountType);
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder.toString();
	}
	
	public static double getDifferenceBetweenPrincipalAndInterest(Account account) {
		return (account.daysActive / DAYS_OF_THE_YEAR) - account.loanValue;
	}
	
	public static double getAccountInterestFee(Account account) {
		return Math.pow(account.monthlyRate, getDifferenceBetweenPrincipalAndInterest(account));
	}
	
	public static double getLoanValueAfterInterestFee(Account account) {
		return account.loanValue * getAccountInterestFee(account);
	}
	
	public static double getAccountFinalFee(Account account) {
		return BROKER_FEE * getLoanValueAfterInterestFee(account);
	}
	
	public void print() {
		for(int vb = 0; vb <= 10; vb++) {
			System.out.println("This is an account");
		}
	}

	public static double getPremiumAndSuperPremiumAccountsTotalFeesValue(Account[] accounts) {
		double totalFee = 0.0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].accountType == AccountType.PREMIUM || accounts[i].accountType == AccountType.SUPER_PREMIUM) {
				totalFee += getAccountFinalFee(accounts[i]);
			}
		}
		return totalFee;
	}

	
	
}
