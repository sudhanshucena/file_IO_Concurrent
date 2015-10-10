package file_IO_threading;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class FileHandler {
	
	//local variables to handle file IO stream
	PrintWriter outputStream=null;
	BufferedReader inputStream=null;
    String localRead;
    List <String> fileData = new ArrayList<String>();
    // function to read a file passed as arguments
    void readFile(String filename) throws IOException {
    	
    	try{
    		//read the file in a while loop until the file pointer 
    		//is not null and display the contents in the console
    		// readLine() returns null if the end of the stream has been reached
    		inputStream = new BufferedReader(new FileReader(filename));
    		
    		while((localRead = inputStream.readLine())  != null){
    			fileData.add(localRead);
    		}
    	}
    	finally{
    		 if (inputStream != null) {
                 inputStream.close();
             }
    	}
    }
     
    	//function to write the output to a file mentioned as the parameter
    synchronized void writeFile(String outputFilename) throws IOException{
	    try{
	    	outputStream = new PrintWriter(new FileWriter(outputFilename));
    		for (String data : fileData){
    			outputStream.println(data+"\n");
    			outputStream.flush();
    			System.out.println(data);
    		}
		}
		finally{
			 if (outputStream != null) {
				 	System.out.println("File Closed");
	                outputStream.close();
	            }
		}
    }
}
