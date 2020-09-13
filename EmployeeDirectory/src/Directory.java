import java.util.*;
import java.io.*;

/**
 * The Directory class contains the names. department, and telephone numbers of the stored employees
 * 
 * @author Jordan Henkelman
 *
 */
public class Directory { 
    // Declaring array list and scanner
	private ArrayList <Person> persons = new ArrayList <Person>();
	private Scanner kb = new Scanner (System.in);
	//declaring and assigning values to global variables
	private int ZERO = 0;
	private int ONE = 1;
    
    public void run() throws FileNotFoundException { 
    	
    	//Loading the data from file
    	loadData();
    }
   
    
	/**
	 * This method loads each employee's information from the file to the array list. All other methods use this information
	 */
    private void loadData() throws FileNotFoundException {
    	
    	//declaring variables
    	String lName;
		String fName;
		char middleIn;
	    String depart;
	    int phoneN;
	    String middleName;
    	
	    //declaring a file 
    	File inFile = new File ("phone.txt");
    	//calling information from the file
    	Scanner in = new Scanner (inFile);
    	
    	//processing
    	//this loop creates objects out of all the employees and adds them to the array list
    	while(in.hasNext()) {
    		
    		//loading employee information from the file
    	    lName = in.next();
    	    fName = in.next();
    	    middleName = in.next();
    	    middleIn = middleName.charAt(ZERO);
    	    depart = in.next();
    	    phoneN = in.nextInt();
    	    
    	    //creating a new person using the person class
    	    Person newEmp = new Person(lName, fName, middleIn, depart, phoneN);
    	    //adding this person to the array list
    	    persons.add(newEmp);
    	}
    	//closing the input file
    	in.close();
    }
	
    
    // methods to process the information required by the menu
    
    
    /**
     * This method prints the contents of the directory. 
     */
    public void optionP() {
    	
    	//output - printing header
    	System.out.println("Name                   Department   Telephone Extension");
    	//processing
    	for (Person addNew:persons) {
    		//output
    		System.out.print(addNew.printOne());
		}
	}
    
    /**
     * This method calls an employee last name parameter, then prints the employee's information or lets the user know if the employee has not been found. 
     */
    public void optionL(String empL) {
    	//declaring variables
    	int foundEmp;
    	
    	//calling the search method to return the index value of the employee. If the employee is not in the system it returns a value of -1
    	foundEmp = searchMethod(empL);
    	
    	//if the employee is already in the array list
    	if (foundEmp >= ZERO) {
    		System.out.println("Employee found.");
    		System.out.println(persons.get(foundEmp).printOne());
    	}
    	//if the employee is not already in the array list
    	else
    		System.out.println("The entered employee is not found in the directory.");
  
    }
    
    /**
     * This method calls the parameter of the department that the user has entered, then prints the information of all employees within that department. 
     */
    public void optionR(String dpmt) {
    	//declaring variables
    	int i;
    	String checkDep;
    	int numEmployeesInDep = ZERO;    // this tracks the amount of employees in the department. The number of employees in the department pre-search is 0. 
    	
    	//processing 
    	//this loop retrieves each employee's department
    	for (i = ZERO; i < persons.size(); i++) {
    		checkDep = persons.get(i).getDepartment();
    		
    		//this checks if the called department matches any of the departments in the array list
    		if (checkDep.equalsIgnoreCase(dpmt)) {
    			numEmployeesInDep = numEmployeesInDep + ONE;     // this adds another employee to the total in the department 
  			
  			    //This prints the header only when the first employee is found within the searched department
    			if (numEmployeesInDep == ONE) {
    				System.out.println();
    				//output
    				//this prints the header
    				System.out.println(checkDep);
    				System.out.println("Name                    Telephone Number");
    			}
    			//output
    			//this prints all of the employees information within the searched department using the second print method
    			System.out.print(persons.get(i).printTwo());
    		}
    	}
    	//if there are no employees in the array list within that department
    	if (numEmployeesInDep == ZERO) {
    		//output
			System.out.print("Department not found.");
    	}
    	System.out.println();
    }
    
    /**
     * This method is for updating the information of an employee. It calls the parameter of a last name 
     * and uses the search method, choice method, and setter method to allow the user to change the employee's department or local phone number or both.
     */ 
    public void optionC(String exportLastN) {
    	//declaring variables
    	String newDepartment;
    	int newNumber;
    	int foundEmpNum;
    	char decision;
    	//these outputs are used in multiple places so I assigned them to variables
    	String noChange = "No change implemented.";
    	String invalid = "Invalid input, no change implemented.";
    	
    	//calling the search method to return the index value of the employee. If the employee is not in the system it returns a value of -1
    	foundEmpNum = searchMethod(exportLastN);
    	
    	//processing 
    	//this prints the found employee's information using the first method to show the user what they can change
    	if (foundEmpNum >= ZERO) {
    		//output
    		System.out.println("Employee information:");
    		System.out.println(persons.get(foundEmpNum).printOne());
    		
    		//requesting if the user would like to change the employee's department
    		System.out.println("Would you like to change the employee's department?");
    		//calling the yes or no method
    		decision = yesOrNo();
    		
    		//processing
    		//if the user answered 'yes' - meaning they would like to change the department
    		if (decision == 'y') {
    			//requesting the user to input data
    			System.out.print("Please enter the new department name: ");
    			newDepartment = kb.nextLine();
    			//setting the new department using the setter method
    			persons.get(foundEmpNum).setDepartment(newDepartment);
    			//output
    			System.out.println("New department set.");
    		}
    		//if the user answered 'no' - meaning they would not like to change the department
    		else if (decision == 'n') {
    			//output
    			System.out.println(noChange);
    		}
    		//if the user answered something invalid
    		else
    			//output
    			System.out.println(invalid);
    			
    		//requesting if the user would like to change the employee's local phone number
    		System.out.println("Would you like to change the employee's local phone number?");
    		//using the yes or no method 
    		decision = yesOrNo();
    			
    		//if the user answered 'yes' - meaning they would like to change the local phone number
    		if (decision == 'y') {
    			//requesting user to input data
    			System.out.print("Please enter the new 4 digit local phone number: ");
    			newNumber = kb.nextInt();
    			//setting the new phone number using the setter method
    			persons.get(foundEmpNum).setPhoneNumber(newNumber);
    			//output
    			System.out.println("New local phone number set.");
    		}
    		//if the user answered 'no' - meaning they would not like to change the local phone number
    		else if (decision == 'n') {
    			//output
    			System.out.println(noChange);
    		}
    		//if the user answered something invalid
    		else
    			//output
    			System.out.println(invalid);
    		//output
    		System.out.print("Directory updated.");
    	}
    	//if the employee does not exist within the array list
    	else 
    		//output
			System.out.println("Employee not found.");
    	
    	System.out.println();
    	
    }

    /**
     * This method calls a last name parameter and allows the user to add that employee to the directory alphabetically. It uses the search method to ensure that the employee is not already in the directory. 
     */
    public void optionA(String empLastNm) {
    	//declaring variables
    	int foundOrNot;
    	String empFirstNm;
    	char empInitial;
    	String empMiddleNm;
    	String empDepartment;
    	int empPhone;
    	String compareLast;
    	boolean last = true;
    	
    	//the search method ensures the employee does not already exist within the array list
    	foundOrNot = searchMethod(empLastNm);
    	
    	//processing
    	//if the employee is not found in the array list
    	if (foundOrNot == -ONE) {
    		//requesting the user to input data
    		System.out.print("Please enter the employee's first name: ");
    		empFirstNm = kb.nextLine();
    		System.out.print("Please enter the employee's middle initial: ");
    		empMiddleNm = kb.nextLine();
    		empInitial = empMiddleNm.charAt(ZERO);
    		System.out.print("Please enter the employee's department: ");
    		empDepartment = kb.nextLine();
    		System.out.print("please enter the employee's local phone number: ");
    		empPhone = kb.nextInt();
    		
    		//using the person class to turn the employee into an object
    		Person newEmp = new Person(empLastNm, empFirstNm, empInitial, empDepartment, empPhone);
    		
    		//this ensures the following loop does not go on infinitely when an employee is added to the last spot on the array list
    		int arraySize = persons.size();
    		
    		//processing
    		//this searches the array list and retrieves employee last names
    		for (int i = ZERO; i < arraySize && last; i++) {
    			compareLast = persons.get(i).getLastNm();
    			
    			//comparing the entered last name to the last names on the array list will return a unicode value. If the value is below 0 then that employee alphabetically belongs in that index spot 
    			if (empLastNm.compareToIgnoreCase(compareLast) < ZERO) {
    				//adding the new employee to this spot
    				persons.add(i, newEmp);
    				//output
    	    		System.out.println("Employee successfully added");
    	    		//the employee is not the last name on the list 
    	    		last = false;
    			}
    			//if the entire array list has been searched and the comparison has not returned a negative number it means the name is last alphabetically
    			else if ((i == persons.size() - 1) && (last)) {
    				//adding the new employee to the end of the list
    				persons.add(newEmp);
    				System.out.println("Employee successfully added");
    			}
    		}
    		
    	}
    	//if the employee is already in the directory
    	else {
    		//output
    		System.out.println("This employee is already in the directory.");
    		System.out.println(persons.get(foundOrNot).printOne());
    	}
    	
    }
 
    /**
     * This method calls a last name parameter, searches the directory and allows the user to delete an employee from the list. 
     */
    public void optionD(String checkLastN) {
    	//declaring variables
    	char delete;
    	int foundEmployee;
    	
    	//calling the search method to return the index value of the employee. If the employee is not in the system it returns a value of -1
    	foundEmployee = searchMethod(checkLastN);
    	
    	//processing
    	//if the employee is found
    	if (foundEmployee >= ZERO) {
    		//output
    		System.out.println("Employee found:");
    		System.out.print(persons.get(foundEmployee).printOne());
    		//requesting if the user would like to delete this employee's data from the directory
    		System.out.println("Would you like to delete this employee from the directory?");
    		//using the yes or no method
    		delete = yesOrNo();
    			
    		//if the user answered 'yes' - meaning they would like to delete the employee
    		if (delete == 'y') {
    			persons.remove(foundEmployee);
    			//output
    			System.out.println("Employee deleted.");
    		}
    		//if the user answered 'no' - meaning they would not like to delete the employee
    		else if (delete == 'n') {
    			//output
    			System.out.println("Employee not deleted.");
    		}
    		//if the employee answered something invalid
    		else 
    			//output
    			System.out.println("Invalid input. Employee not deleted.");
    	}
    	//if the searched employee is not in the array list
    	else
    		//output
    		System.out.println("Employee not found");
   
    	System.out.println();
    }
    
    /**
     * This method calls an filename parameter and creates a new output file with that name then prints all current array list information onto that output file
     * @param fileName    this is the name that the user would like to give the new output file
     * @throws FileNotFoundException   this ensures the program doesn't crash if a file isn't found
     */
    public void optionE(String fileName) throws FileNotFoundException {
    	
    	//creating outfile
    	PrintWriter outFile = new PrintWriter(fileName);
    	//processing
    	//adding all employees to the new file
    	for (Person newEmployeeAdd:persons) {
    		//outputting onto file
    		outFile.print(newEmployeeAdd.fileFormat());
    	}
    	//closing outfile
    	outFile.close();
    	//output
    	System.out.println("File has been created.");
    }

    // helper methods
    
    /**
     * This method calls an entered last name parameter and uses it to search the array list by last name.
     * @return the index number of the found employee. If the searched employee is not found, 
     * then it returns an index value of -1 which does not exist otherwise.
     */
    public int searchMethod(String enteredLastName) {
    	//declaring variables
    	String lastName;
    	int i;
    	int employeeNum = -ONE;            //assigning a default employee number of -1 that stays as -1 if the employee is not found
    	
    	//processing
    	//searching the array list by last name
    	for (i = 0; i < persons.size(); i++) {
    		lastName = persons.get(i).getLastNm();
    		//if there is a last name match, employee number becomes the index of that employee
    		if (lastName.equalsIgnoreCase(enteredLastName)) {
    			employeeNum = i;
    		}
    	}
    	//returning the index number, or -1 if the employee is not found
    	return employeeNum;
    }
    
    /**
     * This method is used to prompt the user to answer 'Yes' or 'No' to any question. 
     * @return the char of the user's answer to the Yes or No question. 
     */
    public char yesOrNo() {
    	//declaring variables
    	String choice;
    	char yOrN;
    	
    	//requesting the user to input data
    	System.out.print("Please type 'Yes' or 'No': ");
    	choice = kb.nextLine();
    	//changing from string to char
		yOrN = choice.toLowerCase().charAt(ZERO);
		
		//returning the char of the answer to the yes or no question
		return yOrN;
    }
   
}
