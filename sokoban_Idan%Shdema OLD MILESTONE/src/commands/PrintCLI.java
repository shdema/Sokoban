package commands;

import levels.Level;

/**
 * Prints to screen the game, steps counter and stars left.
 * @author שדמה
 *
 */
public class PrintCLI implements Printer {

	@Override
	public void print(Level l) {
		char[][] signBoard = l.signBoardMaker();
		for (int i = 0; i < l.getBoundCol(); i++) 
		{
			System.out.println(signBoard[i]);
		}
		System.out.println("Steps: "+l.getSteps());
		System.out.println("Stars left: "+l.getNumOfStars());	
	}
}

