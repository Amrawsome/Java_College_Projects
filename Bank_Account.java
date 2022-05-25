/** * @(#)Assignment_2.java
 *This is a program to make a working bank account
 *This is done in stages the first stage is to print out all the Account details and there credit overdraft as yes or no
 *The next stage is making a login for the account with a pin simulating a ATM
 *Stage three has you making a display menu with 5 options
 * View Bank Statement (method), Change Pin (method), Deposit Money (method),Withdraw Money (method) and Exit (method) and you must lop the menu till they exit
 *The next stage is just cleaing up the the program eg.depositing withdrawing and changing pin making it so when you put in values they update to the new values
 *having it so certain accounts can only withdraw beyond their balance if they have overdraft confirmation
 *and finally having an error checking method to make it so any string inputs entered into a int will not result in an error but a message on how to not get the error
 * Assignment_2 application
 * @author Stephen Moore
 * @version 1.00 2019/11/14
 */
 import java.util.Scanner;//from java lib
public class Bank_Account {//start class
	//global variables = can be used everywhere
	// make reference to the Scanner
	static Scanner input = new Scanner(System.in);
	// create 5 bank accounts ( use your own BankAccount.java here )
    static String accountNames []={"Joeseph", "Rob", "Sean", "Brian", "Dean"};//Names of Accounts
    static String accountPins []={"1111", "2222", "3333", "4444", "5555"};//Pins for the accounts#
    static String userInput;
    static int accountBalances []={150, 250, 375, 495, 505};//Balances for the accounts
    static int creditOverdraft []={1,0,1,0,0};//1=yes 0=no credit overdraft confirmation or denial for accounts
    static int index;
    static int attempts;//to limit account login attempts to 3
	// declare  the flag for the correct account (see file Flag.java)
    public static void main(String[] args) {// start main method
    	//call or run the show all bank account method
		showAllAccounts();
    	//call or run the login method<entry point to ATM
    	loginAccount();
    }//end main method

    //**************************** OTHER METHODS***********************************
    //1.show all accounts method ( see BankAccount.java)
     public static void showAllAccounts(){ //method to show all the accounts
    	//1. Show all account methods
 	  	//print all accounts
    	System.out.println("\t\t\t\t************BANK OF S.O.T.V**************");
    	System.out.println("\t\tAccount Details:");
    	System.out.println("\t\tName:\t\tPin:\t\tBalance:\tCredit Overdraft:");
		//for loop to run through the account names
        	for(int i= 0;i<accountNames.length;i++){//start for
        	//If statement  to run through the accounts and show yes and no instead of 1 and 0
	    		if (creditOverdraft[i]==1){//start if
	    			System.out.println("\t\t"+accountNames[i]+"\t\t"+accountPins[i]+"\t\t"+accountBalances[i]+"\t\tYES");
	    			System.out.println("\t\t------------------------------------------------------------------------");
	    		}//end if
	    		else{//start else
	    			System.out.println("\t\t"+accountNames[i]+"\t\t"+accountPins[i]+"\t\t"+accountBalances[i]+"\t\tNO");
	    			System.out.println("\t\t------------------------------------------------------------------------");
	    		}//end else
    	}//end for
    }//end method 1.

    //2.login method ( see payPalAccount)
	 public static void loginAccount(){//start loginAccount
    	System.out.println("\t\tPlease enter pin");
        //take user input
        String pin=input.next();
        //for loop to check for correct pin
        for (int i = 0; i < accountPins.length; i++){//start for loop
        	if (pin.matches(accountPins[i])){//start if
	        	index = i;
				menuOptions();
        	}//end if
        }//end for
        for(int i= 0;i<accountNames.length;i++){//start for
        //if statement to show that if the pin is not properly it is incorrect
        	if(!pin.matches(accountPins [i])){//start if
        		System.out.println("\t\tIn Correct");
        		attemptsAccount();// run attempts account
        		loginAccount();// run  login account
        	}//end if
        }//end for
    }//end method 2.
    //3. choose Option menu Method ( see payPalAccount)
	public static void menuOptions(){
    	System.out.println("\t\tWelcome "+accountNames [index]);
    	// while loop to keep menu repeating until exit
    	while(true){//start while
    		System.out.println("\t\t****************ATM MENU******************");
    		System.out.println("\t\tPlease choose one of the following options");
    		System.out.println("\t\t------------------------------------------");
	    	System.out.println("\t\t1.Bank Account Statement");
	    	System.out.println("\t\t2.Withdraw");
	    	System.out.println("\t\t3.Deposit");
	    	System.out.println("\t\t4.Change Pin");
	    	System.out.println("\t\t5.Exit Account.");
	    	//take in user option
	    	String option = input.next();
	    	// switch statement to determine option
	    	switch(option){//start switch
	    		case "1":
	    			statementAccount();break;
	    		case "2":
	    			withdrawAccount();break;
	    		case "3":
	    			depositAccount();break;
	    		case "4":
	    			changePinAccount();break;
	    		case "5":
	    			exitAccount();break;
	    		default:
	    			System.out.println("INCORRECT OPTION.");break;
	    	}//end switch
    	}//end while
    }//end method 3.
    //4. bank statement method ( see payPalAccount)
	public static void statementAccount(){
	   	System.out.println("\t\tAccount Name:"+accountNames [index]);
	   	System.out.println("\t\t---------------------------------------");
	    System.out.println("\t\tAccount Balance:"+accountBalances[index]);
	    System.out.println("\t\t---------------------------------------");
	    System.out.println("\t\tAccount Pin:"+accountPins[index]);
	    System.out.println("\t\t---------------------------------------");
	    String overdraft;
		//if to show yes and no for overdraft in the bank statement
 		if (creditOverdraft[index] == 1){//start if
    		overdraft="\t\tYes";
    	}//end if

    	else {//start else
    		overdraft="\t\tNo";
    	}//end else
			System.out.println("\t\tOverdraft:"+overdraft);
    }//end method 4.
    //5. withdraw money method ( see payPalAccount)

    //(take in user input as String and change to int see Assignment 1)
	 public static void withdrawAccount(){//start withdrawAccount
	 	System.out.println("\t\t*********Withdraw Menu***********");
		System.out.println("\t\tHow much do you want to withdraw?");
		//create local variable to take user unput
		userInput = input.next();
		errorChecking();//run error checking
		int withdraw=Integer.parseInt(userInput);
		if(creditOverdraft[index] == 0 && withdraw > accountBalances[index]){//if statement for overdraft confirmation
			System.out.println("\t\tInsufficient Funds, You dont have Overdraft Confirmation");
			System.out.println("\t\t***Please Try Again***");
		}//end if statement

		else{//start else
			System.out.println("\t\tYou Have Overdraft Confirmation");
			accountBalances[index]=accountBalances[index]-withdraw;
			System.out.println("\t\tNew Balance:"+accountBalances[index]);
		}//end else

    }//end method 5.
    //6. deposit money method ( see payPalAccount)
    //(take in user input as String and change to int see Assignment 1)
	public static void depositAccount(){//start depositAccount
		System.out.println("\t\t***********Deposit Menu************");
		System.out.println("\t\tHow much would you like to deposit?");
		userInput = input.next();
		errorChecking();//run error checking
		int deposit = Integer.parseInt(userInput);
		accountBalances[index]=accountBalances[index]+deposit;
		System.out.println("\t\tNew Balances:"+accountBalances[index]);
	}//end method 6.

    //7. change pin method ( see payPalAccount)
	public static void changePinAccount(){//start changePinAccount
		System.out.println("\t\t**********Change Pin Menu***********");
    	System.out.println("\t\tPlease enter new pin");
    	//create local variable to take in user input
    	userInput = input.next();
    	errorChecking();
    	//for loop to check that pin is not in use
    	for(int i=0;i<accountPins.length;i++){//start for
    		while(userInput.matches(accountPins[i])){
    			System.out.println("\t\t---------------------");
    			System.out.println("\t\tPin in use");
    			System.out.println("\t\tPlease enter new pin");
    			System.out.println("\t\t-------------------------");
    			userInput=input.next();
    		}//end while
    	}//end for
    	accountPins[index] = userInput;
    	System.out.println("\t\tNew Account Pin:"+accountPins[index]);
    }//end method 7.
    //8. log out method ( see payPalAccount)
    public static void exitAccount(){//start exitAccount
    	System.out.println("\t\tGoodbye");
    	System.exit(0);
	}//end method 8.
	//9. count method for attemps to log in ( see payPalAccount)
	public static void attemptsAccount(){//start attemptsAccount
	   	attempts++;  // count = count +1
	    System.out.println("\t\tYour incorrect attempts are "+attempts);
	   	//if statement to limit attempts to 3
	    if(attempts==3){//start if
	    	System.out.println("\t\tno more attempts,Goodbye");
	    	System.exit(0);
	    }//end if
    }//end method 9.
	//10.error check method ( see Assignment 1)
	public static void errorChecking(){//start method
		while (!userInput.matches("\\d+")){//start while
			System.out.println("\t\tError,Numbers Only");
			//taking user input
			userInput = input.next();
		}//end while
	}//end method
}//end class