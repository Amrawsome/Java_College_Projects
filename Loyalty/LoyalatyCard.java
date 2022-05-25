package Loyalty;
//this class is a blueprint for a shop loyalty card
//this file will contain all variables and methods
//this file will be used by another class
public class LoyalatyCard {//start class
	//fields ->private -> secure->not visible -> not accessible 
	//solution->Encapsulation> Gets and Sets
	private String cardName;
	private String cardPin;
	private int cardCredit;
	//******************* Constructors*******************
	//constructor with 3 parameters (used for passing values)
	public LoyalatyCard(String name, String pin, int credit) {
		this.cardName = name;
		this.cardPin = pin;
		this.cardCredit = credit;
	}//end constructor
	public LoyalatyCard() {}//empty constructor (used for user input??)
	//********************** Get/Set Methods****************
  	//(Encapsulation) a way to access private fields(global variables)
	public String getCardName() {
		return cardName;
	}//end get
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}//end set
	public String getCardPin() {
		return cardPin;
	}//end get
	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}//end set
	public int getCardCredit() {
		return cardCredit;
	}//end get
	public void setCardCredit(int cardCredit) {
		this.cardCredit = cardCredit;
	}//end set
	//****************** Other Methods *********************
	// over write the default toString method
	@Override
	public String toString() {
		return "Loyalaty Card [Name:" + cardName + ", Pin:" + cardPin + ", Credit:" + cardCredit + "]";
	}//end method
	public void debitMethod(int debit) {
		cardCredit=cardCredit-debit;
	}//end method
	public void creditMethod(int credit) {
		cardCredit=cardCredit+credit;
	}//end method
	public void changePinMethod(String newPin) {
		cardPin=newPin;
	}//end method
}//end class
