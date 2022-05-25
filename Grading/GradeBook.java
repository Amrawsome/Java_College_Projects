package Grading;
public class GradeBook {//start class
	//make variables private to keep them secure
	private String studentName;
	private String studentGrade;
	private int total;
	//method to convert grades to points
	public int pointsCalculator(){
		int points=0;
		//switching the string to a int 
		int grade =Integer.parseInt(getStudentGrade());
		//switch statement to make it so that the grade is divided by 10
		//this makes the number a number between 1 and 10
		//the switch picks this up and converts the number from 1 to 10 to the points that i have inputed
		//if the number is say 9.1 it will just consider it as 9 and give the points it equals to
		switch(grade/10) {
		case 10:points=100;break;
		case 9:points=100;break;
		case 8:points=88;break;
		case 7:points=77;break;
		case 6:points=66;break;
		case 5:points=56;break;
		case 4:points=46;break;
		case 3:points=37;break;
		case 2:points=0;break;
		case 1:points=0;break;
		case 0:points=0;break;
		default:
		}//end switch
		//it sends the points to the console
		return points;
		
	
	}//end method
	
	public GradeBook() {}//end constructor //empty constructor to take inputs

	public GradeBook(String studentName, String studentGrade, int total) {
		super();
		this.studentName = studentName;
		this.studentGrade = studentGrade;
		this.total =total;
	}//end constructor
	//To string is used to change it to string and return the output to the console
	@Override
	public String toString() {
		return "GradeBook [Name=" + getStudentName() ;
	}//end toString
	
	//this returns the value
	public String getStudentName() {
		return studentName;
	}//end get
	
	//this sets the value for the variable
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}//end set

	//this returns the value for this variable
	public String getStudentGrade() {
		return studentGrade;
	}//end get

	//this sets the value for the variable 
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}//end set
	
	//this returns the value for the variable total
	public int getTotal() {
		return total;
	}//end get

	//this sets the value for the variable total
	public void setTotal(int total) {
		this.total = total;
	}//end set	
	
}//end class
