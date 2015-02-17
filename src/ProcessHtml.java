import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;




public class ProcessHtml {
	
	public static void process(File file, int number) throws IOException {
		Document doc = Jsoup.parse(file, "UTF-8", "http://example.com/");
		File xin = new File(file.getParent() + "\\" + number + ".txt");
		System.out.println(xin.toString());
		PrintWriter out = new PrintWriter(xin);
		out.print(doc.text());
		out.close();
	}
	
	public static void processDir(String path) throws IOException {
		File dir = new File(path);
		File[] arr = dir.listFiles();
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].isDirectory()) {
				process(arr[i], i);
			}
		}
	}
	
	public static void del(String path) {
		File file = new File(path);
		File[] arr = file.listFiles();
		for (int i = 0; i < arr.length; i++) {
			String name = arr[i].getName();
			int inx = name.indexOf(".");
			String hind = name.substring(inx+1);
//			System.out.println(hind);
			if (!hind.equals("txt"))
				if (arr[i].delete())
					System.out.println("Deling " + arr[i].getName());
				else {
					File[] files = arr[i].listFiles();
					for (int j = 0; j < files.length; j++) {
						if (files[j].delete())
							System.out.println("Del " + files[j].getName());
					}
					arr[i].delete();
					System.out.println("Deleting " + arr[i].getName());
				}
		}
	}
	
	public static void regex(File file) throws IOException {
		String b = file.getName();
		//xinFile = "F:\\batch6"
		int inx = b.indexOf(".");
		String fileName = b.substring(0, inx);
		String xinFile = file.getParent() + "\\" + fileName +  "1.txt";
		File to = new File(xinFile);
		Scanner input = new Scanner(file);
		PrintWriter output = new PrintWriter(to);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String reg = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
			Pattern pattern = Pattern.compile(reg);
			Matcher match = pattern.matcher(line);
			while (match.find()) {
				output.println(match.group());
			}
		}
		System.out.println("Finish " + file.getName());
		input.close();
		output.close();
	}
	
	public static void copy(File from, File to) throws IOException {
//		File from = new File(source);
//		File to = new File(target);
		
		BufferedInputStream input = 
				new BufferedInputStream(new FileInputStream(from));
		
		BufferedOutputStream output = 
				new BufferedOutputStream(new FileOutputStream(to, true));
		
		int r;
		while ((r = input.read()) != -1) {
			output.write((byte) r);
		}
		
		input.close();
		output.close();
	}
	
	public static void doDir(String dir, String target) throws IOException {
		File ddir = new File(dir);
		String name = ddir.getParentFile().getName();
		File[] files = ddir.listFiles();
		for (int i = 0; i < files.length; i++) {
			String to = target + "\\" + name + ".txt";
			File end = new File(to);
			copy(files[i], end);
			System.out.println("Dealing " + files[i].getAbsolutePath());
		}
		System.out.println("Finished ");
	}
	
	public static void main(String[] args) throws  MalformedURLException, IOException {
		String[] titles = {
				"北京CEO",
				"不动产北京",
				"北京建筑",
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

//		for (int i = 0; i < titles.length; i++) {
//			for (int j = 0; j < emails.length; j++) {
//				String path = "F:\\newyear2" + "\\" + titles[i] + "\\" + emails[j];
//				String a = "F:\\newyear2";
//				String b = a + "\\" + titles[i] + "\\" + emails[j];
//				doDir(b, a); //3rd step, copy all txt. -> parent dir

//				processDir(path); //1st step, htm -> text
//				del(path); //2nd step, del all dirs containing css...
//			}
//		}
		
		File dir = new File("F:\\newyear2");
		File[] ds = dir.listFiles();
		for (int z = 0; z < ds.length; z++) {
			if (!ds[z].isDirectory())
				regex(ds[z]);
		}		
	}
	
}
