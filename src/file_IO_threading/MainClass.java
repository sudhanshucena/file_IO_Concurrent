package file_IO_threading;

public class MainClass {

	public static void main(String args[]) {
    	Thread file1 = new Thread(new ConcurrentFileHandling("qrys.txt","output.txt"));
    	Thread file2 = new Thread(new ConcurrentFileHandling("docs.txt","output.txt"));
    	file1.start();
    	file2.start();
    	try {
			file1.join();
			file2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
