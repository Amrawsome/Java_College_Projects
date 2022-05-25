package Advanced_Bank_Account;
public class SavingsAccount extends Account {//start class that extends class account
	private int interestRate;//integer variable interest rate
	//constructor with 4 parameters
	public SavingsAccount(String accountUser, String accountPin, int accountBalance,  int interestRate) {
		super(accountUser, accountPin, accountBalance);
		this.interestRate = interestRate;
	}//end constructor
	public int getIntrestRate() {//this returns the value
		return interestRate;
	}//end get
	public void setIntrestRate(int intrestRate) {//this sets the value
		this.interestRate = intrestRate;
	}//end set
	// Overrides the toString provided by the Object class.
	@Override
	public String toString() {
		return "Savings "+ super.toString() + " interest Rate:" + interestRate ;
	}//end toString
	//method to add interest to the deposit
	public void deposit(int Amoney) {
		super.deposit(Amoney+addInterest());//adds interest to Amoney
	}//end method
	//add interest for the current period to the account balance.
	public int addInterest() {
		int interest = getAccountBalance() * interestRate / 100;
		return interest;//returns the interest 
	}//end method
	}//end class
