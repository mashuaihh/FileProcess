import java.io.File;
import java.io.IOException;


public class NewDirs {
	public static void newDirs(String path, String[] titles, String[] emails) {
		File rootDir = new File(path);
		rootDir.mkdir();
		for (int i = 0; i < titles.length; i++) {
			String subDirPath = path + "\\" + titles[i];
			File subDir = new File(subDirPath);
			subDir.mkdir();
			System.out.println(subDirPath + " has been founded.");
			for (int j = 0; j < emails.length; j++) {
				String emailDirPath = subDirPath + "\\" + emails[j];
				File emailDir = new File(emailDirPath);
				emailDir.mkdir();
				mkFile(emailDir, titles[i]);
			}
		}	
	}
	
	public static void mkFile(File parentDir, String titleName) {
		String path = parentDir.getPath();
		String txtPath = path + "//" + titleName + ".txt";
		File txt = new File(txtPath);
		try {
			txt.createNewFile();
			System.out.println("Creating : " + txt.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String path = "F:\\newyear6";
		String[] titles = {
				"A Subsidiary of Beijing Email",
				"ADVERSTING & MEDIA Beijing Email",
				"Architectural Design Beijing Email",
				"ASIA BUSINESS DIRECTOR Beijing Email",
				"Asset Management Co.,Ltd Beijing Email",
				"Assistant to CHAIRMAN Beijing Email",
				"Assistant to GM Beijing Email",
				"Beijing Representative Office Beijing Email",
				"Brand Manager Beijing Email",
				"Building Materials Co.Ltd Beijing Email",
				"business council Beijing Email",
				"Chief Editor Beijing Email",
				"CHIEF REPRESENTATIVE Beijing Email",
				"Communication Director Beijing Email",
				"COUNTRY MANAGER Beijing Email",
				"DEPUTY GENERAL MANAGER Beijing Email",
				"Development Corporation Beijing Email",
				"EQUITY INVESTMENT Beijing Email",
				"FUND MANAGEMENT Beijing Email",
				"HEAD OF INVESTMENT Beijing Email",
				"HOLDINGS LIMITED Beijing Email",
				"Interior consultant Beijing Email",
				"International Design Beijing Email",
				"Investment And Consulting Beijing Email",
				"Landscape Design Beijing Email",
				"management Consulting Beijing Email",
				"Market Development Beijing Email",
				"Media Group Beijing Email",
				"Overseas Bank Beijing Email",
				"Securities Co.Limited Beijing Email",
				"VICE CHAIRMAN Beijing Email",
				"Wealth Advisory Beijing Email",
				"WINE & SPIRIT Beijing Email",
				"Studio Beijing Email",
				"Yacht Club Beijing Email",
		};

//		newDirs(path, titles, emails);
		
//		for (int i = 0; i < titles.length; i++) {
//			for (int j = 0; j < emails.length; j++) {
//				String newPath = path + "\\" + titles[i] + " " + emails[j] + ".txt";
//				File file = new File(newPath);
//				try {
//					file.createNewFile();
//					System.out.println(titles[i] + " " + "Bejing email @" + emails[j]);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < titles.length; i++) {
			String path2 = path + "\\" + titles[i] + ".txt";
			File ff = new File(path2);
			try {
				ff.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ff.getName());
		}
		
	}
	
}
