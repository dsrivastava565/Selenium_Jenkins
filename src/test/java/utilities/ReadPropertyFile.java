package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("/Users/deveshsrivastava/Documents/fresh-workspace/testframework/src/test/resources/configfiles/config.properties");
		Properties p = new Properties();
		p.load(fr);
		System.out.print(p.getProperty("browser"));
		
	}

}
