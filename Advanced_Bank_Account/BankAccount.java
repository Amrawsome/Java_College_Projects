package Advanced_Bank_Account;
import java.util.Scanner;
public class BankAccount {//start class
static Scanner input = new Scanner(System.in);
private String accountUser;
private String accountPin;
private int accountBalance;
private int accountID;
private static int nextID=1010;
//constructor with 4 parameters
public BankAccount(String accountUser, String accountPin, int accountBalance, int accountID) {
	super();
	this.accountUser = accountUser;
	this.accountPin = accountPin;
	this.accountBalance = accountBalance;
	this.accountID = nextID++;
}//end constructor
public BankAccount() {}//empty constuctor
public String getAccountUser() {
	return accountUser;
}//end get
public void setAccountUser(String accountUser) {
	this.accountUser = accountUser;
}//end set
public String getAccountPin() {
	return accountPin;
}//end get
public void setAccountPin(String accountPin) {
	this.accountPin = accountPin;
}//end set
public int getAccountBalance() {
	return accountBalance;
}//end get
public void setAccountBalance(int accountBalance) {
	this.accountBalance = accountBalance;
}//end set
public int getAccountID() {
	return accountID;
}//end get
public void setAccountID(int accountID) {
	this.accountID = accountID;
}//end set
public static int getNextID() {
	return nextID;
}//end get
public static void setNextID(int nextID) {
	BankAccount.nextID = nextID;
}//end set
@Override
public String toString() {
	return "Bank Account User:" + accountUser + ", Pin:" + accountPin + ", Balance:"
			+ accountBalance + ",ID:" + accountID + "]";
}//end Method
public void deposit(int Amoney) {
	accountBalance = accountBalance + Amoney;
}//end method
//method for withdrawing money from the bank account
public void withdraw(int Bmoney) {
	accountBalance = accountBalance - Bmoney;
}//end method
public void optionMenu() {
	System.out.println("1.Check bank statement\n2.Withdraw\n3.Deposit\n4.Change Pin\n5.EXit\n");
	while(true) {
		System.out.println("Please enter option");
		String option= input.next();
		switch(option) {
			case "1": System.out.println("Bank Statement");
						System.out.println(toString());break;
			case "2": System.out.println("How Much to Withdraw");
						withdraw(input.nextInt());
						System.out.println("New Balance"+getAccountBalance());break;
			case "3":System.out.println("How Much to Deposit");
						deposit(input.nextInt());
						System.out.println("New deposit="+getAccountBalance());break;
			case "4":System.out.println("Please Enter New Pin");break;
			case "5":System.out.println("GoodBye");
			System.exit(0);break;
			default:
				System.out.println("Incorrect Option. Please Try Again");break;
		
		}//end switch
	}//end while
}//end method

}//end class
