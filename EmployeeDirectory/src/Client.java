import java.io.*;
import java.util.*;
/**
 * This is the interface that the user will use to process the Directory
 * 
 * @author Jordan Henkelman
 * 
 */
public class Client {

	private static Scanner kb = new Scanner (System.in);
	
	public static void main (String [] args) throws FileNotFoundException
	{
		//declaring variables
		String choice;         //which method the user would like to access
		char letter = 'Z';     //turning their choice into a char
		
		Directory dir = new Directory();
		dir.run();
		

		//prints the welcome message
		welcomeMessage();
		
		//processing 
		 //This loop keeps running the program until the user selects E to exit. 
		while (letter != 'E') {
			showMenu();
			System.out.println();
			System.out.print("Please enter a letter listed above: ");
			choice = kb.next().toUpperCase();
			letter = choice.charAt(0);
			
		//this calls the last name entering method and sends that information to the optionP method in the directory class. 
			switch (letter) {
			case 'P':
				//running the optionP method
				dir.optionP();
				break;
			
		//this calls the last name entering method and sends that information to the optionL method in the directory class. 	
			case 'L':
				String checkName;
				
				//calling the last name entering method
				checkName = enterLastNm();
				//sending the entered last name to the directory class optionL
				dir.optionL(checkName);
				break;
			
		//this calls the last name entering method and sends that information to the optionR method in the directory class. 
			case 'R': 
				String accessDepartment;
				
				//requesting user to input data
				System.out.print("Please enter the name of the department: ");
		    	accessDepartment = kb.next();
		    	//sending entered department data to the directory class optionR and running that method
		    	dir.optionR(accessDepartment);
		    	break;
		    	
		 //this calls the last name entering method and sends that information to the optionC method in the directory class. 
			case 'C':
				String exportLastName;
				
				//calling the last name entering method
		        exportLastName = enterLastNm();
		        //sending the entered last name to the directory class optionC and running that method
		        dir.optionC(exportLastName);
		        break;
		     
		 //this calls the last name entering method and sends that information to the optionA method in the directory class. 
			case 'A':
				String empLName;
				
				//calling the last name entering method
		        empLName = enterLastNm();
		        //sending the entered last name to the directory class optionA and running that method
		        dir.optionA(empLName);
		        break;
		     
		 //this calls the last name entering method and sends that information to the optionD method in the directory class. 
			case 'D':
				String last;
				
				//calling the last name entering method
		        last = enterLastNm();
		        //sending the entered last name to the directory class optionD and running that method 
		        dir.optionD(last);
		        break;
		     
		  //this calls the last name entering method and sends that information to the optionE method in the directory class. 
			case 'E':
				String fileN;
				
				//requesting the user to input data
				System.out.print("Please enter the desired name of the new directory save file without extensions: ");
				fileN = kb.next();
				//adding .txt to the file name
				fileN = fileN + ".txt";
				
				//sending file name to directory class optionE and running that method
				dir.optionE(fileN);
				break;
				
		    //this prints if the user does not input a valid character when prompted
			default:
				//output
				System.out.print("Invalid input");
				System.out.println();
			}
		}
		//this calls the exit message method to thank the user for using the program
		exitMessage();
		
	}
	
	/**
     *  The Directory processing menu
     */
    public static void showMenu()
    {
        System.out.println("\nMENU:");
        System.out.println("P - Print directory contents");      // i added this one
        System.out.println("L - Look up a person's number");
        System.out.println("R - Create a report with a department phone list");
        System.out.println("C - Change a listing");
        System.out.println("A - Add  new Listing");
        System.out.println("D - Delete a listing");
        System.out.println();
        System.out.println("E - Exit");
    }
    
    /**
     * This method prompts the user to input an employee's last name. 
     * All methods that use this argument are case insensitive but this method 
     * requests the first letter to be capitalized for file output purposes.
     * @return the employee's last name
     */
    public static String enterLastNm() {
    	//declaring variables
    	String exportName;
    	
    	//requesting user to input data
    	System.out.print("Please enter the employee's last name with a capital first letter: ");
        exportName = kb.next();
        System.out.println();
        
        //returns the entered last name
        return exportName;
    }
    
    /**
     * This method prints a welcome message
     */
    public static void welcomeMessage() {
    	//output
    	System.out.println("Welcome to the directory.");
    }
    
    /**
     * This method prints an exit message
     */
    public static void exitMessage() {
    	//output
    	System.out.println("Thank you for using the Directory System.");
    }
 
}
