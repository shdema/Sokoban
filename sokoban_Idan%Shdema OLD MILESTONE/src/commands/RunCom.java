package commands;

import java.util.Scanner;

/**
 * The main class.
 * @author שדמה
 *
 */
public class RunCom {

	public static void main(String[] args) {
			
		CLI cli = new CLI();
		
		String str;
		Scanner s = new Scanner(System.in);

		do 
		{
			System.out.println("Please enter command:");
			str = s.nextLine();
			cli.whatToDo(str);
			
		} while (!str.equals("Exit")); //until the user types 'Exit'
		
		s.close();

	}
}
