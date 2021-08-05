import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author alexclevenger
 * @version 0.1 Date of creation: March 10, 2021 
 * Last Date Modified: March 11, 2021
 *
 * 
 * 
 */
public class Recursion {
/**
 * Main method that runs the program 
 * @param args
 */
	public static void main(String args[]) {
		int count = 0;
		Scanner scan = new Scanner(System.in);
		String units = "";

		do { //loop to display prompts repeatedly
			System.out.println("-----------------------");
			System.out.println("Enter a directory name: ");
			String in = scan.next(); //user input
			long s = getSize(in);
			/**
			 * calculates the proper units for the total size
			 */
			if (s >= 0 && s < 1000) {
				units = "Bytes"; 
			}
			if (s >= 1000 && s < 1000000) {
				units = "Kbytes";
				s /= 1000;
			}
			if (s >= 1000000 && s < 1000000000) {
				units = "Mbytes";
				s /= 1000000;
			}
			if (s >= 1000000000 && s < 1000000000000L) {
				units = "Gbytes";
				s /= 1000000000;
			}
			System.out.println("Total size of " + in + " is " + s + " " + units);
			System.out.println("The total number of files in " + in + " is " + fileCount(in) + " files");

		} while (count < 99);  //arbitrary number of times the program runs
	}
/**
 * 
 * @param name
 * @return long which is the total size of all the files in the directory (if it is not a file already)
 */
	public static long getSize(String name) {

		long result = 0;
		File current = new File(name);

		if (!(current.isFile() || current.isDirectory())) { //checks to see if the file/directory even exists
			return 0;
		}
		if (current.isFile()) {
			return current.length(); //checks to see if a file
		} else {

			File[] fileList = current.listFiles(); 

			for (int i = 0; i < fileList.length; i++) { //iterates through directory
				if (fileList[i].isFile()) {
					result += fileList[i].length(); //add to total 
				}
				if (fileList[i].isDirectory()) {

					result += getSize(fileList[i].getPath()); //go deeper recursively 

				}

			}
		}

		return result;
	}
	/**
	 * Method that returns the total number of files in a directory
	 * @param name
	 * @return int the number of files 
	 */

	public static int fileCount(String name) {

		int count = 0;
		File current = new File(name);

		if (!current.exists()) {
			System.out.println("File or Directory does not exist"); //checks to see if file/directory even exists
		} else {

			File[] fileList = current.listFiles();

			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile()) { //if file is in current directory, add to total count
					count++;

				} else if (fileList[i].isDirectory()) {
					count += fileCount(fileList[i].getPath());  //go deeper and count more files recursively

				}

			}
		}

		return count;

	}

}
