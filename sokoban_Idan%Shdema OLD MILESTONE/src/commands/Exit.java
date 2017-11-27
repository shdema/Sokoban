package commands;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Exit command. We created an exit instance in CLI to manage opened streams.
 * @author שדמה
 *
 */
public class Exit implements Command {

	private InputStream is;
	private OutputStream os;
	
	public Exit()
	{
		is = null;
		os = null;
	}
	
	public Exit(Exit exit)
	{
		this.is = exit.is;
		this.os = exit.os;
	}

	
	@Override
	public void execute() {
		//close streams if they are open
		if (is != null)
		{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (os != null)
		{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	//sets and gets
	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}


}
