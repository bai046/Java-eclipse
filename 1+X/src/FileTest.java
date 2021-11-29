package test.point;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FileTest {

	public static void main(String[] args) throws Exception {
		File file = new File(".");
		System.out.println(file.getAbsolutePath());
		file = new File(".project");
		FileInputStream is = new FileInputStream(file);
//		is.read()
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(is));
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
		is.getChannel();
	}
	

}
