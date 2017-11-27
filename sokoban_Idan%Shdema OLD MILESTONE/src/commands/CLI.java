package commands;

import levels.Level;

/**
 * The Command Line Interface - responsible for commands, uses CommandFactory according to user input
 * @author שדמה
 *
 */
public class CLI {

	private Level l;
	private Exit exit;
	private boolean loaded;
	
	public CLI()
	{
		l=new Level();
		exit = new Exit();
		loaded = false;
	}
	
	public void whatToDo(String com){

		String firstword;
		int index = com.indexOf(" ");
		if (index!=-1)
		{
			firstword = com.substring(0, index);
		}
		else
			firstword = com;
		
		if (!firstword.equals("Load") && !loaded)
		{
			System.out.println("Load a level please!");
			return;
		}
		else
		{
			loaded=true;
			CommandFactory cf = new CommandFactory(com,l,exit);
			Command c = cf.createCommand();
			if (c != null) //c exists
			{
				if (cf.getFirst().equals("Load")) //only allowed command
				{
					c.execute();
					l.getTimer().start();
				}

				else //not "Load"
				{
						c.execute(); //there is a level, all commands allowed

				}
			}
			else
				System.out.println("No such command.\n");
		}
	}
	
	//sets and gets
	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

	public Exit getExit() {
		return exit;
	}

	public void setExit(Exit exit) {
		this.exit = exit;
	}
		
}
