package Loyalty;

import java.util.Scanner;// from the Java Lib
//this is the start of the application
//this is the entry point =Main Method
public class StartApplication extends LoyalatyCard {//start class
	//make reference to the LoyalatyCard class
	//create an object of LoyalatyCard and assign it a reference value
	//create arrays
	static LoyalatyCard[] card= new LoyalatyCard[5];
	//make reference to the Scanner
	public static Scanner input= new Scanner(System.in);
	//flag for the correct account
    public static int index;
	public static void main(String[] args) {//start main
		createDatabaseMethod();
		loginMethod();
	}//end main
	private static void createDatabaseMethod() {
		//build the array of accounts
		card[0]=new LoyalatyCard("John","1234",150);
		card[1]=new LoyalatyCard("Joan","2345",250);
		card[2]=new LoyalatyCard("Jean","3456",350);
		card[3]=new LoyalatyCard("Jake","4567",450);
		card[4]=new LoyalatyCard("Jack","5678",550);
		
		//print out database
		System.out.println("************ Member ACCOUNTS *************");
		for(int i=0;i<card.length;i++) {
			System.out.println(card[i].toString());
		}//end for loop
		
	}//end method
	private static void loginMethod() {
		System.out.println("Please enter Pin");
		String pin=input.next();
		//for loop to test the correct pin
		for(int i=0;i<card.length;i++) {
			if(pin.matches(card[i].getCardPin())) {
				System.out.println("Correct");
				index=i;
				menuMethod();
			}//end if
		}//end for loop
	}//end method
	private static void menuMethod() {
		System.out.println("Welcome "+card[index].getCardName());
		while (true) {
			System.out.println("Please choose one of the following options");
			System.out.println("1.Member Statement\n2.Add Credit" + "\n3.Deduct Credit\n4.Change Pin\n5.Exit");
			String option = input.next();
			// switch statement to choose options
			switch (option) {
				case "1":bankStatementMethod();break;
				case "2":addMethod();break;
				case "3":subtractMethod();break;
				case "4":newPinMethod();break;
				case "5":exitMethod();break;
				default:System.out.println("SEND USER SOMEWHERE");
			}//end switch
		}//end while
	}//end method
	private static void exitMethod() {
		System.out.println("Goodbye....");System.exit(0);
		
	}//end method
	private static void newPinMethod() {
		System.out.println("Please enter your new pin");
        //take user input
        String newPin=input.next();
        //for loop to run it 5 times
        for(int i= 0;i<card.length;i++){
        	//while loop to see is the pin is already in use
            while(newPin.matches(card[i].getCardPin())){
          		System.out.println("The pin is already in use");
          		System.out.println("Please enter another pin");
          		newPin=input.next();
            }//end while
            //changing the old pin into a new pin
        }//end for
		
	}//end method
	private static void subtractMethod() {
		System.out.println("How much are you subtracting");
		int debit= input.nextInt();
		//test if enough credit in account
		if(debit>card[index].getCardCredit()) {
			System.out.println("\nInsufficient Funds, You don't have overdraft");
		    System.out.println("***Please Try Again***");
		}//end if
		else {
			card[index].debitMethod(debit);
			System.out.println("Thank you for your debit, your new balance is ");
			System.out.println(card[index].getCardCredit());
		}//end else
	}//end method
	private static void addMethod() {
		System.out.println("How much are you adding");
		int credit= input.nextInt();
		card[index].creditMethod(credit);
		//card[index].creditMethod(input.nextInt());
		System.out.println("Thank you for your credit, your new balance is ");
		System.out.println(card[index].getCardCredit());
		
	}//end method
	private static void bankStatementMethod() {
		System.out.println(card[index].toString());
	}//end method

}//end class
