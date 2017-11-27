package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import levels.Level;
import levels.LevelLoader;
import levels.LoaderFactory;

/**
 * Command that load specific file by extension with Factory pattern 
 * @author שדמה
 *
 */
public class LoadFileName implements Command {
	
	private String fileName;
	private Level l;
	private InputStream is;
	
	LoadFileName(String fn, Level l, Exit exit)

	{
		this.l = l;
		fileName = fn;

		
		try {
			is = new FileInputStream(fileName);
			exit.setIs(is); //sets 'is' in the exit instance of CLI
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute() {
		LoaderFactory lf = new LoaderFactory();
		LevelLoader ll = lf.createLoader(fileName);
		
		Level temp = new Level(ll.loadLevel(is)); //we set every member of level
		l.setBoard(temp.getBoard());
		l.setBoundCol(temp.getBoundCol());
		l.setBoundRow(temp.getBoundRow());
		l.setBoxes(temp.getBoxes());
		l.setChars(temp.getChars());
		l.setNumOfStars(temp.getNumOfStars());
		l.setSteps(temp.getSteps());
		l.setTimer(temp.getTimer());
	}

	//gets and sets
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

	public InputStream getIs() {
		return is;
	}
	
	public void setIs(InputStream is) {
		this.is = is;
	}
 
}
