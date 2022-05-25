/**
 * @(#)Assignment1.java
 * Introduction goes here.This program is to take in grades for a class and give
 * the highest,lowest and average of the grades.
 * @author Stephen Moore
 * @version 1.00 2019/10/6
 */
import java.util.Scanner;//from the Java library
public class Class_Grading {//start class

    //make reference to the Scanner
    static Scanner input = new Scanner(System.in);
    //declare global variables (can be used through out the program)
    static String className;
    static String userInput;
    static int grade,classNum=0,totalPass=0,totalFail=0,highGrade=0,lowGrade=101,total;
    public static void main(String[] args) {//start main

    //declare variables
		System.out.println("\t\t\t******************************");
    	System.out.println("\t\t\t\t  GradeBook");
    	System.out.println("\t\t\t******************************");
    	System.out.println("\t\t\tPlease enter class name");

    	className= input.next();
    	System.out.println("\t\t\tHow many students are in "+className);
    	userInput = input.next();
    	errorChecking();
    	classNum=Integer.parseInt(userInput);
		System.out.println("\t\t\tPlease Enter Grade");
//for loop
   	for(int i=1;i<=classNum;i++){
    	System.out.println("\t\t\tGrade:"+i);
    	userInput = input.next();
    	errorChecking();
    	grade=Integer.parseInt(userInput);
    	//call or run the method
		gradeMethod();
     }//end for Loop
      //run print report here
      finalPrint();

    }//end main

    //******************** OTHER METHODS *****************
    // 1.Process Grade Method
    public static void gradeMethod(){
    		 //if statement for pass,fail
    if (grade>=50){
    	totalPass=totalPass+1;
    }//end if statement
    else{
    	totalFail=totalFail+1;
    }//end else if
    //highest
    if(grade>highGrade){
    	highGrade=grade;
    }//end if statement
   //lowest
   if(grade<lowGrade){
		lowGrade=grade;
   	}//end if statement
   	//calculate total
	total=total+grade;
    }// end grademethod

    // 2.Final Print out Method
    public static void finalPrint(){
    	System.out.println("\t\t\t**********************");
    	System.out.println("\t\t\tPass:"+totalPass);
    	System.out.println("\t\t\tFail:"+totalFail);
    	System.out.println("\t\t\tHighest Grade:"+highGrade);
    	System.out.println("\t\t\tLowest Grade:"+lowGrade);
    	System.out.println("\t\t\tAverage Grade:"+total/classNum);
    	System.out.println("\t\t\tTotal Points:"+total);
    	System.out.println("\t\t\t**********************");
    }//end method

    // 3.Error checking Method
    public static void errorChecking(){
    	while(!userInput.matches("\\d+")){
    		System.out.println("ERROR,numbers only");
    		userInput= input.next();
    	}//end while
    }//end method

}//end class