package levels;

import java.io.IOException;
import java.io.OutputStream;

/**
 * XML saver - by serialization.
 * @author שדמה
 *
 */
public class MyXMLLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(String fileName, Level l, OutputStream os) {

			try {
				Serialization.writeSer(l, fileName); //write the level into obj file
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
