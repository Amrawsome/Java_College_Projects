package Advanced_Bank_Account;
public class CurrentAccount extends Account {//start class that extends account class
	private static final int  TRANSACTION_FEE =2;//setting the transaction fee
	
	 //constructor with 4 parameters
	public CurrentAccount(String accountUser, String accountPin, int accountBalance) {
		super(accountUser, accountPin, accountBalance);
	}//end constructor
	public void deposit(int Amoney)  {
		super.deposit(Amoney-TRANSACTION_FEE);//this is the transaction fee being taken away from the deposit amount
	}//end method
	public void withdraw(int Bmoney) {
		super.withdraw(Bmoney+TRANSACTION_FEE);//this is the transaction fee being added onto the withdrawal amount
	}//end method
	// Overrides the toString provided by the Object class.
	@Override
	public String toString() {
		return "Current " + super.toString();
	}//end toString
}//end class
