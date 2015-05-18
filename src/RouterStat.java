import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RouterStat {
	private String path = "d:\\icn-content.txt";
	private String targetPath;

	public List<String> lcdHitRate = new ArrayList<String>();
	public List<String> ccnHitRate = new ArrayList<String>();
	public List<String> clsHitRate = new ArrayList<String>();
	public List<String> clsPlusHitRate = new ArrayList<String>();

	public List<String> lcdPathStr = new ArrayList<String>();
	public List<String> ccnPathStr = new ArrayList<String>();
	public List<String> clsPathStr = new ArrayList<String>();
	public List<String> clsPlusPathStr = new ArrayList<String>();

	public List<String> algoStrList = new ArrayList<String>();
	public List<String> hitStrList = new ArrayList<String>();
	public List<String> psStrList = new ArrayList<String>();
	
	public List<Block> hitRateList = new ArrayList<Block>();
	public List<Block> PsList = new ArrayList<Block>(); 

	private boolean read = false;
	String algo;

	private class Block {
		private List<String> block = new ArrayList<String>();

		public Block() {
		}
		
		public void addOneBlock(String str) {
			block.add(str);
		}
		
		public List<String> getBlock() {
			return block;
		}
	}
	
	public RouterStat() {
	}
	
	public void setTargetPath(String str) {
		this.targetPath = str;
	}
	
	public void setAlgo(String str) {
		this.algo = str;
		this.algoStrList.clear();
		this.hitStrList.clear();
		this.psStrList.clear();
	}
	
	public List<String> getHitStrList() {
		//Hit rate: 0.0041
		for (String str : this.algoStrList) {
			int idxOfR = str.indexOf("r");
			if (idxOfR == 4) {
				int idxDot2 = str.indexOf(".");
				String newstr = str.substring(idxDot2 - 1);
				this.hitStrList.add(newstr);
			}
		}
		return this.hitStrList;
	}
	
	public List<String> getPsStrList() {
		//Path Stretch: 0.99914
		for (String e : this.algoStrList) {
			int idx = e.indexOf("P");
			if (idx == 0) {
				int idxDot2 = e.indexOf(".");
				String newe = e.substring(idxDot2 - 1);
				this.psStrList.add(newe);
			}
		}
		return this.psStrList;
		}
	
	public void process() {
		File inFile = new File(this.targetPath);
		try {
			Scanner in = new Scanner(inFile);
			
			
//			if (this.algo.equals("lcd")) {
//				hitRateList = this.lcdHitRate;
//				PsList = this.lcdPathStr;
//			} else if (this.algo.equals("ccn")) {
//				hitRateList = this.ccnHitRate;
//				PsList = this.ccnPathStr;
//				
//			} else if (this.algo.equals("cls")) {
//				hitRateList = this.clsHitRate;
//				PsList = this.clsPathStr;
//
//			} else if (this.algo.equals("cls+")) {
//				hitRateList = this.clsPlusHitRate;
//				PsList = this.clsPlusPathStr;
//			} 

			int times = 1;

			while(in.hasNext()) {
				String line = in.nextLine();

				//if str is empty
				if (line.equals("")) {
					this.read = false;
				}
				
				//if should read, read!
				if (this.read == true) {
					this.algoStrList.add(line);
					System.out.println(line);
				}

				//if str is 
				//aa : -0.3 denomin: 0.1 Algorithm: lcd
				if (isBlockStart(line)) {
					this.read = true;
				} 
				
				if (times == 2) {
					//Hit rate: 0.0023
					int dotIdx = line.indexOf(".");
					String hitRate = line.substring(dotIdx - 1);
//					System.out.println("hit " + hitRate);
//					hitRateList.add(hitRate);
				}
				
				if (times == 3) {
					int dotIdx = line.indexOf(".");
					String ps = line.substring(dotIdx - 1);
//					System.out.println("Ps " + ps);
//					PsList.add(ps);
				}
			
				if (line.length() > 1) {
					String aa = line.substring(0, 2);
					if (aa.equals("aa")) {
						int len = line.length();
						int idx = len - 3;
						String algo = line.substring(idx);
						if (algo.equals(this.algo)) {
							times = 1;
						}
					}
					
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public boolean isBlockStart(String line) {
				if (line.length() > 1) {
					String aa = line.substring(0, 2);
					if (aa.equals("aa")) {
						int len = line.length();
						int idx = len - 3;
						String algo = line.substring(idx);
						if (algo.equals(this.algo)) {
							return true;
						}
						}
					}		
				return false;
	}

	public void printHit() {
	}
	
	public static void main(String[] args) {
		
		File file = new File("d:\\collectedResult.txt");
//		File file = new File("d:\\HitResult n=6 sb6.txt");

		RouterStat rs = new RouterStat();

		PrintWriter fileOut = null;

		try {
			fileOut = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rs.setTargetPath("d:\\HitResult n=6 sb6.txt");
		
		String[] algos = {"ccn","lcd", "cls", "ls+"};
//		String[] algos = {"ccn"};
		
		List<String> hitStrList = null;
		List<String> PsStrList = null;

		for (int i = 0; i < algos.length; i++) {
			String algo = algos[i];
			rs.setAlgo(algo);
			rs.process();
			hitStrList = rs.getHitStrList();
			PsStrList = rs.getPsStrList();

			fileOut.println(algo+ ":");
			fileOut.println("Hit rate:");
			int m = 0;
			for (String s : hitStrList) {
				if (m == 5) {
					fileOut.println();
				}
				fileOut.println(s);
				m++;
			}
			fileOut.println();
			
			fileOut.println("Path Stretch:");
			int n = 0;
			for (String s : PsStrList) {
				if (n == 5) {
					fileOut.println();
				}
				fileOut.println(s);
				n++;
			}
			fileOut.println();

		}		
		
		fileOut.close();
		
		

	}
}
