package Grading;
import java.util.Scanner;//taken from java library
public class UseGradeBook {//start class
	//make connection between two classes
	static GradeBook report= new GradeBook();
	//make reference to scanner
	static Scanner input= new Scanner(System.in);
	//variable to take in input
	static String takeInput;
	//variable to count the total points
	static int total;
	
	public static void main(String[] args) {//start main 
		//to print out the question to enter their name
		System.out.println("Please Enter Student Name");
		//to take in the input which is there name
		report.setStudentName(input.next());
		//for loop to repeat print the question 
		//and take in input for the grade so it can then be sent and converted to points
		for(int i=1;i<=6;i++) {
			//print out asking them to enter the grade
			System.out.println("Please Enter Student Grade");
			//taking the answer/input
			takeInput=input.next();
			//this is to run the error checking method/ call errorChecking 
			report.setStudentGrade(errorChecking(takeInput));
			//this will count up the total points
			total=total+report.pointsCalculator();
		}//end for loop
		
		//this will print out the ToString and the total grade
		System.out.println(report.toString()+",Total Points="+  total+"]");
		

		
	   	}//end main
	//this is the error checking method
	public static   String errorChecking(String takeInput){
		//while statement to error check for letters in numbers spots
    	while(!takeInput.matches("\\d+")){
    		System.out.println("ERROR,numbers only");
    		takeInput = input.next();
    	}//end while
    	//returns output to console
    	return takeInput;
    }//end method
	
}//end class
