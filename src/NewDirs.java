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
		String path = "F:\\newyear2";
		String[] titles = {
				"����CEO",
				"����������",
				"��������",
				"Beijing office",
				"Beijing branch",
				"Investments Beijing",
		};
		String[] emails = {
				"126",
				"163",
				"139",
				"qq",
				"hotmail",
				"sohu",
				"sina",
				"gmail",
				"yahoo",
		};
		newDirs(path, titles, emails);
	}
}
