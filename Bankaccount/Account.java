package Bankaccount;
//this class is to be for accounts
//this file will contain all variables and methods
//this file will be used by another class
public class Account {//start class
	//fields ->private -> secure->not visible -> not accessible 
	//solution->Encapsulation> Gets and Sets
	//these are the private string and int variables
	private String bankName ;
	private String bankPin  ;
	private int bankBalance ;
	//******************Constructors**************************\\
	public Account(String Name, String Pin, int Balance) {
		this.bankName = Name;
		this.bankPin =Pin;
		this.bankBalance = Balance;
	}//end constructor
	public Account() {}// empty constructor used for user input
	//*************************GET AND SET METHODS******************\\
	//(Encapsulation) a way to access private fields(global variables)
	//this returns the value
	public String getBankName() {
		return bankName;
	}//end get
	//this sets the value
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}//end set
	//this returns the value
	public String getBankPin() {
		return bankPin;
	}//end get
	//this sets the value
	public void setBankPin(String bankPin) {
		this.bankPin = bankPin;
	}//end set
	//this returns the value
	public int getBankBalance() {
		return bankBalance;
	}//end get
	//this sets the value
	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}//end set
	//****************** Other Methods *********************
	// over write the default toString method
	@Override
	public String toString() {
		return "Account [Name=" + bankName + ", Pin=" + bankPin + ", Balance=" + bankBalance+ "]";
	}//end toString
	//made so deposit adds to bankBalance
	public void bankDeposit (int deposit) {
		bankBalance=bankBalance + deposit;
	}//end bankDeposit
	//made so withdraw subtracts from bankBalance
	public void bankWithdraw (int withdraw) {
		bankBalance=bankBalance - withdraw;
	}//end bankWithdraw
	//made to be able to change pin
	public void changePin(String newPin) {
		bankPin=newPin;
	}//end changePin
}//end class
