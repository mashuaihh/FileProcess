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
		String path = "F:\\newyear4";
		String[] titles = {
				"Aaron",
				"Adam",
				"Alan",
				"Amy",
				"Andrea",
				"Andrew",
				"Angela",
				"Ann",
				"Anthony",
				"April",
				"Barbara",
				"Benjamin",
				"Beth",
				"Billy",
				"Bobby",
				"Bradley",
				"Brenda",
				"Brent",
				"Brett",
				"Brian",
				"Bruce",
				"Bryan",
				"Carl",
				"Carla",
				"Carlos",
				"Carol",
				"Carolyn",
				"Carrie",
				"Catherine",
				"Chad",
				"Charles",
				"Cheryl",
				"Chris",
				"Christina",
				"Christine",
				"Christopher",
				"Cindy",
				"Corey",
				"Craig",
				"Curtis",
				"Cynthia",
				"Dana",
				"Daniel",
				"Danny",
				"Darren",
				"David",
				"Dawn",
				"Deanna",
				"Deborah",
				"Debra",
				"Denise",
				"Dennis",
				"Derek",
				"Derrick",
				"Diana",
				"Diane",
				"Donald",
				"Donna",
				"Douglas",
				"Edward",
				"Elizabeth",
				"Eric",
				"Frank",
				"Gary",
				"George",
				"Gerald",
				"Gina",
				"Gregory",
				"Heather",
				"Heidi",
				"Holly",
				"Jacqueline",
				"James",
				"Janet",
				"Jason",
				"Jay",
				"Jeffery",
				"Jeffrey",
				"Jennifer",
				"Jeremy",
				"Jerry",
				"Jessica",
				"Jill",
				"Jimmy",
				"Jodi",
				"Joe",
				"Joel",
				"John",
				"Johnny",
				"Jon",
				"Jonathan",
				"Jose",
				"Joseph",
				"Juan",
				"Julie",
				"Karen",
				"Katherine",
				"Kathleen",
				"Kathy",
				"Keith",
				"Kelly",
				"Kenneth",
				"Kevin",
				"Kim",
				"Kimberly",
				"Kristen",
				"Kristin",
				"Lance",
				"Larry",
				"Laura",
				"Laurie",
				"Lawrence",
				"Leslie",
				"Linda",
				"Lisa",
				"Lori",
				"Marc",
				"Marcus",
				"Margaret",
				"Maria",
				"Mark",
				"Martin",
				"Mary",
				"Matthew",
				"Melanie",
				"Melinda",
				"Melissa",
				"Michael",
				"Michelle",
				"Michelle",
				"Monica",
				"Nancy",
				"Nicole",
				"Pamela",
				"Patricia",
				"Patrick",
				"Paul",
				"Paula",
				"Peter",
				"Philip",
				"Phillip",
				"Rachel",
				"Randall",
				"Randy",
				"Raymond",
				"Rebecca",
				"Regina",
				"Renee",
				"Rhonda",
				"Richard",
				"Robert",
				"Robin",
				"Rodney",
				"Roger",
				"Ronald",
				"Russell",
				"Samuel",
				"Sandra",
				"Sarah",
				"Scott",
				"Sean",
				"Shane",
				"Shannon",
				"Sharon",
				"Shawn",
				"Shelia",
				"Sherry",
				"Stacey",
				"Stacy",
				"Stephanie",
				"Stephen",
				"Steven",
				"Susan",
				"Suzanne",
				"Tamara",
				"Tammy",
				"Tanya",
				"Tara",
				"Teresa",
				"Terry",
				"Theresa",
				"Thomas",
				"Tiffany",
				"Timothy",
				"Tina",
				"Todd",
				"Tony",
				"Tonya",
				"Tracey",
				"Traci",
				"Tracy",
				"Travis",
				"Troy",
				"Valerie",
				"Victoria",
				"Vincent",
				"Walter",
				"Wayne",
				"Wendy",
				"William",
		};
//		String[] emails = {
//				"all.com",
//		};
//		newDirs(path, titles, emails);
		for (int i = 0; i < titles.length; i++) {
			String newPath = path + "\\" + "William" + "\\" + titles[i] + ".txt";
			File file = new File(newPath);
			try {
				file.createNewFile();
				System.out.println("create " + file.getName() + "  " + i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
