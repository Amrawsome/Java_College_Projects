package Advanced_Bank_Account;
//this class is to be for accounts
//this file will contain all variables and methods
//this file will be used by another class
import java.util.Scanner;//taken from java library
public class Account {//start class
	//make reference to scanner
	public static Scanner input = new Scanner(System.in);
	private String accountUser;//String variable accountUser
	private String accountPin;//String variable accountPin
	private int accountBalance;//integer variable accountBalance
	private int accountID;// integer variable accountID
	//next ID is initialized  to 1010. It is this value for all objects of this class
	//until it is changed. 
	private static int nextID=1010;// 1010, 1011,1012,1013,1014,1015
	//constructor with 4 parameters
	public Account(String accountUser, String accountPin, int accountBalance ) {
		this.accountUser = accountUser;
		this.accountPin = accountPin;
		this.accountBalance = accountBalance;
		this.accountID = nextID++;
	}//end constructor
	public Account() {}//empty constructor for user input
	public String getAccountUser() {//this returns the value
		return accountUser;
	}//end get
	public void setAccountUser(String accountUser) {//this sets the value
		this.accountUser = accountUser;
	}//end set
	public  String getAccountPin() {//this returns the value
		return accountPin;
	}//end get
	public void setAccountPin(String accountPin) {//this sets the value
		this.accountPin = accountPin;
	}//end set
	public int getAccountBalance() {//this returns the value
		return accountBalance;
	}//end get
	public void setAccountBalance(int accountBalance) {//this sets the value
		this.accountBalance = accountBalance;
	}//end set
	public int getAccountID() {//this returns the value
		return accountID;
	}//end get
	public void setAccountID(int accountID) {//this sets the value
		this.accountID = accountID;
	}//end set
	public static int getNextID() {//this returns the value
		return nextID;
	}//end get
	public static void setNextID(int nextID) {//this sets the value
		Account.nextID = nextID;
	}//end set
	// Overrides the toString provided by the Object class.
	//@return String representation of the account
	@Override//
	public String toString() {
		return "Account " + " User:" + accountUser + " Pin:" + accountPin + " Balance:"
			+ accountBalance + " ID:" + accountID;
	}//end Method
	//method to deposit money into the bank account
	public void deposit(int Amoney) {
		accountBalance = accountBalance + Amoney;
	}//end method
	//method for withdrawing money from the bank account
	public void withdraw(int Bmoney) {
		accountBalance = accountBalance - Bmoney;
	}//end method
	//method to change pin
	public void changePin(String newPin) {
		accountPin=newPin;//linking account pin and new pin
	}//method
	//method for ATM menu
	public void optionMenu() {
		System.out.println("1.Check bank statement\n2.Withdraw\n3.Deposit\n4.Change Pin\n5.Exit\n");//system print out with all the menu options
		while(true) {//this while is for running the ATMmenu on a loop
			System.out.println("Please enter option");//print out asking you to enter the option number
			String option= input.next();//making options take in input
			switch(option) {//switch statement to choose option
				case "1": System.out.println("Bank Statement:");//print out statement saying bank statement
							System.out.println(toString());break;//printing out the to string showing the account details
				case "2": System.out.println("How Much to Withdraw");//print statement asking how much to withdraw
							withdraw( errorChecking (input.next()));//withdraw method with error checking running in it, also taking input
							System.out.println("New Balance: "+getAccountBalance());break;//print statement giving the new balance
				case "3":System.out.println("How Much to Deposit");//print statement asking how much to deposit
							deposit(errorChecking(input.next()));// deposit method running taking in input with error checking running in it
							System.out.println("New Balance:"+getAccountBalance());break;//printing out the new deposit with the new balance
				case "4":System.out.println("Please Enter New Pin");//print statement asking to enter new pin
				setAccountPin(StartATM.accountNewPin(input.next()));break;//takes in new pin and sets it 
				case "5":System.out.println("GoodBye");//print statement saying goodbye
				System.exit(0);break;//kicking you out of the system
				default://what will happen if anything but the set inputs are entered
					System.out.println("Incorrect Option. Please Try Again");break;// Print statement saying that you have entered an incorrect option and to try again
			}//end switch
		}//end while
	}//end method
	//start method used to check that only numbers are being entered in the only numbers spot
	public static int errorChecking(String userInput){
		while (!userInput.matches("\\d+")){//start while to check for error
			System.out.println("Error,Numbers Only");//print out to show that there is a error
			//taking user input
			userInput= input.next();
		}//end while
		return Integer.parseInt(userInput);//returning an int as a string 
	}//end error checking

}//end class

