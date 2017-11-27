package commands;

import levels.Level;
/**
 * Command for displaying game on screen
 * @author שדמה
 *
 */
public class Display implements Command {

	private Level l;
	
	public Display(Level l)
	{
		this.l=l;
	}

	@Override
	public void execute() {
		PrintCLI pcli = new PrintCLI(); //the print class for CLI
		pcli.print(l);
	}
	
	//sets and gets
	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

}
