package file_IO_threading;

import java.io.IOException;

public class ConcurrentFileHandling implements Runnable{
	String inputFileName,outputFileName;
	public ConcurrentFileHandling(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		FileHandler fileObject = new FileHandler();
    	try {
    		System.out.println("Thread "+ t.getName()+" Started Writing");
			fileObject.readFile(inputFileName);
			
			System.out.println("Thread "+ t.getName()+" Finished Writing");
			fileObject.writeFile(outputFileName);
		} catch (IOException e) {
			 
			//Handles IO errors
			System.out.println("Some IO error occured please see the stacktrace below");
			e.printStackTrace();
		}
		
	}

}
