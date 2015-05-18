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
			
				String newline = titleList.get(i) + " " + "Real Estate" + " Email";
				System.out.println("Creating " + newline);
				outWrite.println(newline);
			//Michael ¡°Real Estate¡± Email
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
		 
//		 try {
//			make(title, mail, out);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		 
		String[] tit = {
				"\"Development Corporation\" Beijing Email",
				"\"A Subsidiary of\" Beijing Email",
				"\"Market Development\" Beijing Email",
				"\"International Design\" Beijing Email",
				"\"Building Materials Co.Ltd\" Beijing Email",
				"\"Beijing Representative Office\" Beijing Email",
				"\"WINE & SPIRIT\" Beijing Email",
				"\"Overseas Bank\" Beijing Email",
				"\"Investment And Consulting\" Beijing Email",
				"\"Media Group\" Beijing Email",
				"\"Architectural Design\" Beijing Email",
				"\"ADVERSTING & MEDIA\" Beijing Email",
				"\"HOLDINGS LIMITED\" Beijing Email",
				"\"Securities Co.Limited\" Beijing Email",
				"\"business council\" Beijing Email",
				"\"Landscape Design\" Beijing Email",
				"\"Asset Management Co.,Ltd\" Beijing Email",
				"\"management Consulting\" Beijing Email",
				"\"Wealth Advisory\" Beijing Email",
				"Yacht Club: Beijing Email",
				"Studio Beijing Email",
				"\"EQUITY INVESTMENT\" Beijing Email",
				"\"FUND MANAGEMENT\" Beijing Email",
				"\"CHIEF REPRESENTATIVE\" Beijing Email",
				"\"DEPUTY GENERAL MANAGER\" Beijing Email",
				"\"COUNTRY MANAGER\" Beijing Email",
				"\"Assistant to GM\" Beijing Email",
				"\"ASIA BUSINESS DIRECTOR\" Beijing Email",
				"\"Interior consultant\" Beijing Email",
				"\"Assistant to CHAIRMAN\" Beijing Email",
				"\"Communication Director\" Beijing Email",
				"\"HEAD OF INVESTMENT\" Beijing Email",
				"\"VICE CHAIRMAN\" Beijing Email",
				"\"Chief Editor\" Beijing Email",
				"\"Brand Manager\" Beijing Email",
		};
		String[] mail2 = {
				"126.com",
				"qq.com",
				"vip.sina.com",
				"yahoo.com",
				"163.com",
				"139.com",
//				"hotmail.com",
//				"gmail.com",
		};
		for (int i = 0; i < tit.length; i++) {
			for (int j = 0; j < mail2.length; j++) {
				String newline = tit[i] + " @ " + mail2[j];
				System.out.println(newline);
			}
			System.out.println();
		}
		 
	}
}
