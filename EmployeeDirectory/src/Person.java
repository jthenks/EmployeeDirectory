/**
 * This class holds all the information related to the stored employees.
 * @author Jordan Henkelman
 *
 */

public class Person {
	
	//instance variables
	private String firstName;
	private String lastName;
	private char initial;
	private String department;
	private int phoneNumber;
	
	/**
	 * Default constructor
	 */
	public Person() {
	}
	
	/**
	 * Parameterized constructor 
	 * @param firstNm    this parameter is the called employee's first name
	 * @param ini        this parameter is the called employee's middle initial
	 * @param lastNm     this parameter is the called employee's last name
	 * @param depart     this parameter is the called employee's department
	 * @param phone      this parameter is the called employee's number extension
	 */
	public Person(String lastNm, String firstNm, char ini, String depart, int phone) {
		firstName = firstNm;
		lastName = lastNm;
		initial = ini;
		department = depart;
		phoneNumber = phone;
	}
	
	/** Accessor
	 * This method accesses the employee's first name
	 * @return the employee's first name
	 */
	public String getFirstNm() {
		
		return firstName;
	}
	
	/**Accessor
	 * This method accesses the employee's last name
	 * @return the employee's last name
	 */
	public String getLastNm() {
		
		return lastName;
	}
	
	/**Accessor
	 * This method accesses the employee's middle initial
	 * @return the employee's middle initial
	 */
	public char getInitial() {
		
		return initial;
	}
	
	/**Accessor
	 * This method accesses the employee's department
	 * @return the employees department 
	 */
	public String getDepartment() {
		
		return department;
		
	}
	
	/**Accessor
	 * This method accesses the employee's phone number extension
	 * @return phone number extension
	 */
	public int getPhoneNum() {
		
		return phoneNumber;
	}
	
	/**Mutator
	 * This method calls a String and sets it as the employee's first name
	 * @param fName    this parameter is the called String of the employee's first name
	 */
	//mutators
	public void setfirstNm(String fName) {
		
		firstName = fName;
	}
	
	/**Mutator
	 * This method calls a String and sets it as the employee's last name
	 * @param lName    this parameter is the called String of the employee's last name
	 */
	public void setLastNm(String lName) {
		
		lastName = lName;
	}
	
	/**Mutator
	 * This method calls a char and sets it as the employee's middle initial
	 * @param init     this parameter is the called char of the employee's name
	 */
	public void setInitial(char init) {
		
		initial = init;
	}
	
	/**Mutator
	 * This method calls a String and sets it as the employee's department
	 * @param dep      this parameter is the called String of the employee's department
	 */
	public void setDepartment(String dep) {
		
		department = dep;
	}
	
	/**Mutator
	 * This method calls an integer and sets it as the employee's department 
	 * @param num      this parameter is the called integer of the employee's local phone number
	 */
	public void setPhoneNumber(int num) {
		
		phoneNumber = num;
	}
	
	/**Helper method
	 * This method converts all employee information into a String in the format for the first print method
	 * @return the String containing all employee information formatted using the second method
	 */
	public String printOne() {
		String text;
		text = String.format("%-7s %-1c. %-11s %-12s %-4d %n",  firstName, initial, lastName , department , phoneNumber);
		
		return text;
	}

	
	/**Helper method
	 * This method converts all employee information into a String in the format for the second print method 
	 * @return the String containing all the employee information formatted using the second method
	 */
	public String printTwo() {
		String text1;
		text1 = String.format("%-7s %-1c. %-12s %-4d %n", firstName, initial, lastName, phoneNumber);
		
		return text1;
	}
	
	/**
	 * This method converts all employee information into a String in the format for storing the file data
	 * @return  the String containing all the employee information formatted using the file format method
	 */
	public String fileFormat () {
		String text2;
		
		text2 = String.format("%-11s %-7s. %-1c %-12s %-4d %n",  lastName, firstName, initial , department , phoneNumber);
		
		return text2;
	}
	
}