// Raika Roy Choudhury, Peterson APCS Per # 2
// Chapter 6 Programming Project 
// 06 December 2021

// This program prompts the user for a baby name and outputs information on the popularity of the name, if found, by accessing the file names.txt
import java.io.*;
import java.util.*;

public class BabyNames {

	// This is the main method, which prints out lines for formatting, creates scanners, and checks with user
	// whether they'd like to search another name
	public static void main(String[] args) throws FileNotFoundException{
		Scanner file = new Scanner(new File("names.txt"));
		Scanner console = new Scanner(System.in);
		
		System.out.println("** Popularity of a baby name since year 1900 **");
		System.out.println();
			
		scanning(false, file, console);
		
		System.out.println("Would you like to search another name? ");
		String answer = console.next();
		boolean condition = answer.charAt(0) == 'y' || answer.charAt(0) == 'Y';
		
		while (condition) {
			scanning(false, file, console);
			System.out.println("Would you like to search another name? ");
			answer = console.next();
		}

			
	}
	
	// This method scans the file for the name, checks if the name is in the file, and both creates a new file for 
	// & prints out information based on the name if found. 
	public static void scanning(boolean found, Scanner file, Scanner console) throws FileNotFoundException {
		int yr = 1900; 
		
		System.out.println();
		System.out.println("name?");
		
		String inputName = console.next();
		
		while(file.hasNextLine() && found == false) {
			if (file.hasNext()) {
			String line = console.nextLine();
			Scanner scan = new Scanner(line); 
			String scanName = scan.next();
			
			
			if (inputName.equalsIgnoreCase(scanName)) {
				PrintStream output = new PrintStream(new File(inputName + ".txt"));
				while (scan.hasNextInt()){
					int next_Int = scan.nextInt(); 
					System.out.println(yr + ": " + next_Int); 
					output.println(yr + ": " + next_Int); 
					yr += 10; 
				}
				
				found = true; 
			}
			}
			
		}
		
		if (found == false) {
			System.out.println("name not found.");
		}
		
		
		System.out.println("");
	} 
		

}
