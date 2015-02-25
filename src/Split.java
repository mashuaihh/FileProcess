import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// used to cut a e-book txt file into several parts
// according to the delimiter, for example "Chapter [0-9]"

public class Split {
	private File txt = null;
	private static int number = 0;
	private static PrintWriter out = null;
	private static File outFile = null;
	
	public Split(String path) {
		this.txt = new File(path);
	}
	
	public void showSplitter(String regex) throws IOException {
			Scanner in = new Scanner(this.txt, "UTF-8");
			while (in.hasNextLine()) {
				String each = in.nextLine();
				if (each.matches(regex)) {
					System.out.println(each);
				}
			}
			in.close();
	}
	
	public void cutSplit(String regex) throws FileNotFoundException {
		Scanner in = new Scanner(this.txt, "UTF-8");
		outFile = new File(this.getPath());
		out = new PrintWriter(outFile);
		while (in.hasNextLine()) {
			String each = in.nextLine();
//			System.out.println(each);
			if (!each.matches(regex)) {
				out.println(each);
			}
			else {
				number++;
				out.close();
				outFile = new File(this.getPath());
				out = new PrintWriter(outFile);
				out.println(each);
				System.out.println(each);
			}
		}
		in.close();
		
	}
	
	private String getPath() {
		return this.txt.getParent() + "\\" + dotName(this.txt.getName()) + number + ".txt";
	}
	
	private static String dotName(String str) {
		int dot = str.indexOf(".");
		return str.substring(0, dot);
	}
	
	
	public static void main(String[] args) throws IOException {
		String path = "E:\\电子书\\Mars\\mars.txt";
		Split ss = new Split(path);
		ss.cutSplit("(Chapter  [0-9][0-9]?|Chapter  [0-9][0-9]     )");
		//UTF-8不知为何有超级多 空格字符，但使用\\s和直接打  空格无法匹配。
		//将txt中的空格字符直接粘贴进入程序中，会提示编码问题
		//按提示存为UTF-8后，匹配成功。
	}
}
