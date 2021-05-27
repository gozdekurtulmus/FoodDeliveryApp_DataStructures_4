package FoodDeliveryApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

	public FileIO() {
	}	
	
	// Returns a string array from the given csv file.
	public String[][] readToArray(String fileName) {
		String[][] returnArray = null;
		try {
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			String line = br.readLine();
			returnArray = new String[findSize(fileName)][line.split(",").length];
			int i = 0;
			while( line != null) {
				returnArray[i] = line.split(",");
				line = br.readLine();
				i++;
			}
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();	
		}	
		
		return returnArray;		
	}

	//Finds the size of the given file.
	private int findSize(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		int count =0;
		while ((line != null)){
			count++;
			line = reader.readLine();
		}
		reader.close();
		return count;
	}
	
}
