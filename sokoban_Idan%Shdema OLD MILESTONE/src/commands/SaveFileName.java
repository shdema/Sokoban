package commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import levels.Level;
import levels.LevelSaver;
import levels.SaverFactory;

/**
 * Command that saves specific file by extension with Factory pattern
 * @author שדמה
 *
 */
public class SaveFileName implements Command {

	private String fileName;
	private OutputStream os;
	private Level l;
	
	
	SaveFileName(String fn, Level l, OutputStream os, Exit exit){
		fileName=fn;
		this.l = l;
		this.os = os;
		
		try {
			os = new FileOutputStream(fileName);
			exit.setOs(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute() {
		SaverFactory lf = new SaverFactory();
		LevelSaver ll = lf.createSaver(fileName);
		ll.saveLevel(fileName,l,os);
	}
	
	
	//gets and sets
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}

}
