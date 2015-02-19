import java.io.File;


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
			}
		}	
	}
	
	public static void main(String[] args) {
		String path = "F:\\newyear3";
		String[] titles = {
				"Private Equity Beijing Email",
				"Wealth Management Beijing Email",
				"Securities Beijing Email",
				"New York Beijing",
				"San Francisco Beijing",
				"Paris Beijing",
				"PR Manager Beijing Email",
				"Event Director Beijing Email",
				"Consulate General Beijing Email",
				"Project Manager Beijing Email",
				"Artistic Director Beijing Email",
				"Coordinator Beijing Email",
				"Beijing branch Luxury Email",
				"Beijing office Luxury Email",
				"Frank Beijing email",
				"Shirley Beijing email",
				"Sherry Beijing email",
				"Jessica Beijing email",
				"James Beijing email",
				"Cindy Beijing email",
				"Michelle Beijing email",
				"Michael Beijing email",
				"Ashley Beijing email",
				"Chris Beijing email",
				"Stephen Beijing email",
				"Mark Beijing email",
				"Laurent Beijing email",
				"Eileen Beijing email",
				"Jacqueline Beijing email",
				"Zoe Beijing email",
				"Grace Beijing email",
				"Roberto Beijing email",
				"Salvatore Beijing email",
		};
		String[] emails = {
				"gmail.com",
				"hotmail.com",
				"126.com",
				"163.com",
				"sohu.com",
				"sina.com",
				"qq.com",
				"yahoo.com",
				"vip.sina.com",
				"139.com",
		};
		newDirs(path, titles, emails);
	}
}
