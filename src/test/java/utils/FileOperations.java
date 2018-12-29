package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOperations {

	public static void CreateChildFolders(String ParentFolderName,
			String ChildFolderName) {
		try {
			File file = new File(ParentFolderName);
			if (!file.exists()) {
				file.mkdir();
			}
			ChildFolderName = ParentFolderName + "\\" + ChildFolderName;
			File files = new File(ChildFolderName);
			if (!files.exists()) {
				files.mkdirs();
			} else {
				System.out.println("failed to create sub directories");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
 	}

	public static void CreateTextFile(String Filename) {
		try {
			File file = new File(Filename);

			// Create the file
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void CreateTextFile(String Filename, String textToAppend) {
		try {
			File file = new File(Filename);

			// Create the file
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(Filename,
					true)); // Set true for append mode
			writer.newLine(); // Add new line
			writer.write(textToAppend);
			writer.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static String GetCurrentDateAsPerGivenFormat(String DateFormat) {
		String Currentdate = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(DateFormat);
			Date date = new Date();
			Currentdate = formatter.format(date);
		} catch (Exception ex) {
			System.out.println("Error in formatting current date");
		}

		return Currentdate;
	}

}
