package Advanced_Bank_Account;
import java.util.Scanner;//taken from java library
public class StartATM extends Account {//start class that extends class account
	//make reference to scanner
	public static Scanner input = new Scanner(System.in);
	static Account savings []= new SavingsAccount[3];//creating an account object and assigning it a reference value
	static Account current []= new CurrentAccount[3];//creating an account object and assigning it a reference value
	private static int attempts;//integer variable attempts
	private static String userInput;//String variable
	public static void main(String[] args) {//start main
		bankDatabase();//run bankDatabase
		accountLogin();//run accountLogin
	}//end main
	private static void bankDatabase() {
		//build array of savings and current accounts
		savings[0]= new SavingsAccount("Stephen Moore","1123",1000,2);
		savings[1]= new SavingsAccount("Alannah Rubins","5764",1200,2);
		savings[2]= new SavingsAccount("Brian Hennesy","9764",2100,2);
		current[0]= new CurrentAccount("Stephen Moore","3211",200);
		current[1]= new CurrentAccount("Alannah Rubins","4675",400);
		current[2]= new CurrentAccount("Brian Hennesy","4697",300);
	}//end method
	private static void accountLogin() {//start accountLogin to be able to log into the account
		System.out.println("*************Welcome To The Bank Of Colaiste Dhulaigh********************");//print statement saying welcome to coliaste dhulaigh bank
		System.out.println("\t\t\tPlease Enter Your Pin");//print statement asking you to enter your pin
		userInput=input.next();//taking in user input
		String pin=userInput; //links string user input and string variable pin
		errorChecking();//run error checking
		for(int i=0;i<current.length;i++) {//start for loop to check for pin for current account
			while(pin.matches(current[i].getAccountPin())) {//if statement to match correct pin for current accounts
				System.out.println("Correct");//print statement saying correct
				current[i].optionMenu();//runs the options menu for current accounts
			}//end if
		}//end for
		for(int i=0;i<savings.length;i++) {//start for loop to check for pin for savings account
			while(pin.matches(savings[i].getAccountPin())) {// if statement to match correct pin for savings accounts 
				System.out.println("Correct");//print statement saying correct
			savings[i].optionMenu();//runs options menu for savings accounts
			}//end if
		}//end for
		attemptsAccount();//runs attemptsAccount	
		accountLogin();//runs accountLogin
	}//end method
	private static void attemptsAccount() {//made so three incorrect attempts can be made on system before forced exit
		attempts++;  // count = count +1
  	    System.out.println("Your incorrect attempts are "+attempts);//tells you how many incorrect attempts you've made
  	   	//if statement to limit attempts to 3
  	    if(attempts==3){//start if
			System.out.println("no more attempts,Goodbye");//print out to tell you, you've no more attempts
  	    	System.exit(0);//close program
  	    }//end if
    }//end attemptsAccount
	public static String accountNewPin(String newPin) {//start userNewPin used to change pin to a new original pin
		newPin=userInput;//linking string userInput and String NewPin
		errorChecking();//run error checking
		//for loop to run it 5 times
		for(int i= 0;i<savings.length;i++){//for loop to check pins in savings accounts
			while(newPin.matches(savings[i].getAccountPin())){//if statement to see if a pin from the savings array matches
				System.out.println("The pin is already in use");//print out statement to say pin already in use
				System.out.println("Please enter another pin");//print out statement to enter new pin
				newPin=input.next();//links string new pin and string variable input.next
			}//end while
		}//end for
		for(int i= 0;i<current.length;i++){//for loop to check pins in current accounts
			while(newPin.matches(current[i].getAccountPin())){//if statement to see if a pin from the current array matches
				System.out.println("The pin is already in use");//print out statement to say pin already in use
				System.out.println("Please enter another pin");//print out statement to enter new pin
				newPin=input.next();//links string new pin and string variable input.next
			}//end if
		}//end for	
		System.out.println("New Account Pin:"+ newPin);//prints out new
		return newPin;//returns new pin
	}//end userNewPin
	public static int errorChecking(){//start error checking to check for errors in the inputs
		while (!userInput.matches("\\d+")){//start while to check for error
			System.out.println("Error,Numbers Only");//print out to show that there is a error
			//taking user input
			userInput= input.next();//taking in user input
		}//end while
		return Integer.parseInt(userInput);//returns integer as a string variable
	}//end error checking
}//end class
