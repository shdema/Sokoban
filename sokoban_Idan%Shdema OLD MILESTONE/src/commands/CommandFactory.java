package commands;

import java.io.OutputStream;
import java.util.HashMap;

import levels.Level;

/**
 * Creates commands with hashMap encoded by names of commands.
 * @author שדמה
 *
 */
public class CommandFactory {

		private String first;
		private String restCom;
		private Level l;
		private OutputStream os;
		private Exit exit;
		private HashMap<String,Creator> commandCreator;

		public CommandFactory(String allCommand, Level l, Exit exit) {
			//initialize data members
			this.exit = exit; //the specific exit that contains the opened input and output streams
			int index = allCommand.indexOf(" ");
			
			//cut the command
			if (index!=-1)
			{
				first = allCommand.substring(0, index);
				restCom = allCommand.substring(index+1);
			}
			
			//just one word
			else
			{
				first = allCommand;
				restCom = "";
			}
			
			this.l = l; //init level
			
			commandCreator = new HashMap<String, Creator>();
			commandCreator.put("Load", new LoadCreator());
			commandCreator.put("Display", new DisplayCreator());
			commandCreator.put("Move", new MoveCreator());
			commandCreator.put("Save", new SaveCreator());
			commandCreator.put("Exit", new ExitCreator());
		}
		
		public Command createCommand()
		{
			
			Creator c = commandCreator.get(first); //create a command with the first word
			
			if (c!=null)
				return c.create();

			return null; //also if the extension is not recognized
		}
		
		private interface Creator{
			public Command create();
		}
		
		private class LoadCreator implements Creator {
			
			public Command create() {
				return new LoadFileName(restCom,l,exit);
			}
		}
		
		private class DisplayCreator implements Creator {
			
			public Command create() {
				return new Display(l);
			}
		}
	
		private class MoveCreator implements Creator {

			public Command create() {
				return new Move(restCom,l,l.getChars().get(0)); //our only character so far...
			}
		}
	
		private class SaveCreator implements Creator {

			public Command create() {
				return new SaveFileName(restCom,l,os,exit);
			}
		}
		
		private class ExitCreator implements Creator {
			
			public Command create() {
				return exit;
			}
		}

		//gets and sets
		public String getFirst() {
			return first;
		}

		public void setFirst(String first) {
			this.first = first;
		}

		public String getRestCom() {
			return restCom;
		}

		public void setRestCom(String restCom) {
			this.restCom = restCom;
		}

		public HashMap<String, Creator> getCommandCreator() {
			return commandCreator;
		}

		public void setCommandCreator(HashMap<String, Creator> commandCreator) {
			this.commandCreator = commandCreator;
		}

		public Level getL() {
			return l;
		}

		public void setL(Level l) {
			this.l = l;
		}

		public OutputStream getOs() {
			return os;
		}

		public void setOs(OutputStream os) {
			this.os = os;
		}

		public Exit getExit() {
			return exit;
		}

		public void setExit(Exit exit) {
			this.exit = exit;
		}
		
		
		
}
