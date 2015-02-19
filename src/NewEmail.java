import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class NewEmail {
	public NewEmail() throws FileNotFoundException {
	
	}
	
	public static void make(String inTitles, String inEmails, String outFile) throws FileNotFoundException {
		File out = new File(outFile);
		File titles = new File(inTitles);
		File mails = new File(inEmails);
		
		Scanner titleInput = new Scanner(titles);
		Scanner mailInput = new Scanner(mails);
		PrintWriter outWrite = new PrintWriter(out);
		
		ArrayList<String> titleList = new ArrayList<String>();
		ArrayList<String> mailList = new ArrayList<String>();
		
		while (titleInput.hasNextLine()) {
			String titleLine = titleInput.nextLine();
			titleList.add(titleLine);
		}
		
		while (mailInput.hasNextLine()) {
			String mailLine = mailInput.nextLine();
			mailList.add(mailLine);
		}
		
		for (int i = 0; i < titleList.size(); i++) {
			for (int j = 0; j < mailList.size(); j++) {
				String newline = titleList.get(i) + " @" + mailList.get(j);
				System.out.println("Creating " + newline);
				outWrite.println(newline);
			}
			outWrite.println();
		}
		
		titleInput.close();
		mailInput.close();
		outWrite.close();
	}
	
	public static void main(String[] args) {
		 String title = "D:\\titles.txt";
		 String mail = "D:\\mail.txt";
		 String out = "D:\\endResult.txt";
		 
		 try {
			make(title, mail, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
}
