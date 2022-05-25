package Bankaccount;
import java.util.Scanner;//taken from java library
//this is the start of the application
//this is the entry point =Main Method
public class StartApplication {//start class
	//make reference to scanner
	public static  Scanner input = new Scanner(System.in);
	//make reference to the Account class
	//create an object of Account and assign it a reference value
	static Account[]  user = new Account [5];
	public static int index;//integer variable index
	public static int attempts;//integer variable attempts
	public static String userInput;//string variable userInput
	public static void main(String[] args) {//start main
	bankDatabase();//run bankDatabase
	loginAccount();//run loginAccount
	}//end main
	private static void bankDatabase() {//start of bankDatabase used to hold the  user accounts
		//build the array of accounts
		user[0]=new Account("Alannah","1234",150);
		user[1]=new Account("Brian","2345",250);
		user[2]=new Account("Anna","3456",350);
		user[3]=new Account("Aisling","4567",450);
		user[4]=new Account("Rob","5678",550);
	}//end bankDatabase
	private static void loginAccount(){//start loginAccount to be able to log into an account 
		System.out.println("Please enter pin");//print out Please enter Pin
		//take user input
		userInput=input.next();
		errorChecking();//run error checking
        String pin=userInput;//links string userInput and String variable pin
        //for loop to check for correct pin
        for (int i = 0; i < user.length; i++){//start for loop
			//if statement to match correct Pin
			if (pin.matches(user[i].getBankPin())){//start if
				System.out.println("Correct");//print out Correct
				index = i;//make it so index is equal to i
				bankMenu();//run bankMenu
       	   }//end if
       }//end for
    attemptsAccount();//run attemptsAccount used to make it so only 3 attempts can be made to log in incorrectly before forced exit
    loginAccount();//run loginAccount
    }//end loginAccount
	private static void attemptsAccount() {//made so three incorrect attempts can be made on system before forced exit
		attempts++;  // count = count +1
  	    System.out.println("Your incorrect attempts are "+attempts);//tells you how many incorrect attempts you've made
  	   	//if statement to limit attempts to 3
  	    if(attempts==3){//start if
			System.out.println("no more attempts,Goodbye");//print out to tell you, you've no more attempts
  	    	System.exit(0);//close program
  	    }//end if
    }//end attemptsAccount
	private static void bankMenu() {//start bankMenu this is the menu for the ATM
		System.out.println("Welcome "+user[index].getBankName());//Print out welcome and the accounts name
		while (true) {//start while to only activate if true
			System.out.println("Please choose one of the following options");//print out asking you to choose one of the following options
			System.out.println("1.Member Statement\n2.Deposit" + "\n3.Withdrawl\n4.Change Pin\n5.Exit");//print out of the options
			userInput=input.next();//take inputs
			errorChecking();//run error checking
			String option=userInput;//linking option and userInpu
			// switch statement to choose options
			switch (option) {//start switch
				case "1":userStatement();break;//case 1 running userStatement
				case "2":userDeposit();break;//case 2 running userDeposit
				case "3":userWithdraw();break;//case 3 running userWithdraw
				case "4":userNewPin();break;//case 4 running userNewPin
				case "5":userExit();break;//case 5 running userEXit
				default:System.out.println("INCORRECT OPTION");break;//Prints out if a number without a case is imputed
			}//end switch
		}//end while
    }//end bankMenu
	private static void userExit() {//start userExit used to close the program and exit the user
		System.out.println("Goodbye....");System.exit(0);//print out goodbye and closes program
	}//end userExit
	private static void userNewPin() {//start userNewPin used to change pin to a new original pin
		System.out.println("Please enter your new pin");//print out to enter new pin
		//take user input
		userInput=input.next();
		errorChecking();//run error checking
		String newPin=userInput;//linking string userInput and String NewPin
		//for loop to run it 5 times
		for(int i= 0;i<user.length;i++){
			//while loop to see is the pin is already in use
			while(newPin.matches(user[i].getBankPin())){
				System.out.println("The pin is already in use");//print out statement to say pin already in use
				System.out.println("Please enter another pin");//prin out statement to enter new pin
				newPin=input.next();//take user input
			}//end while
        }//end for
		//changes old pin to new pin
		user[index].changePin(newPin);
		System.out.println("New Account Pin:"+user[index].getBankPin());//prints out new pin
	}//end userNewPin
	private static void userDeposit() {//start userDeposit used to deposit money in account
		System.out.println("How much are you Depositing");//print out to ask how much the user is depositing
		userInput= input.next();//take user input
		errorChecking();//run error checking
		int deposit = Integer.parseInt(userInput);// Changing userInput String value to int value
		user[index].bankDeposit(deposit);//changing old deposit figure to new one
		System.out.println("Thank you for your deposit, your new balance is ");//print out thank you for the deposit your new balance is
		System.out.println(user[index].getBankBalance());//print out new balance
	}//end userDeposit
	private static void userWithdraw() {//start userWithdraw used to withdraw money from the account if you have sufficient funds
		System.out.println("How much are you Withdrawing");//print statement
		userInput= input.next();//take input
		errorChecking();//run errorChecking
		int withdraw = Integer.parseInt(userInput);//change String userInput to int 
		if(withdraw>user[index].getBankBalance()) {//if statement to only allow withdrawl with sufficient funds
			System.out.println("Insufficient Funds");//print insufficient funds
		    System.out.println("***Please Try Again***");///print please try again
		    System.out.println(user[index].getBankBalance());//print balance
		}//end if
		else {//else to withdraw when you have sufficient funds
			user[index].bankWithdraw(withdraw);//changing old withdraw figure to new one
			System.out.println("Thank you for your withdrawl, your new balance is ");//print  thank you for your withdrawl, your new balance is
			System.out.println(user[index].getBankBalance());//print statement printing new balance
		}//end else
	}//end userWithdraw
	private static void userStatement() {//start user Statement to print out your name pin and balance
		System.out.println(user[index].toString());
	}//end userStatement
	private static void errorChecking(){//start method used to check that only numbers are being entered in the only numbers spot
		while (!userInput.matches("\\d+")){//start while to check for error
			System.out.println("Error,Numbers Only");//print out to show that there is a error
			//taking user input
			userInput= input.next();
		}//end while
	}//end errorChecking
}//end class
