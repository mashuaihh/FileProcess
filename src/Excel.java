import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;


public class Excel {
	public static void fileToExcel(File txtFile) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Workbook wb = new HSSFWorkbook();
	    //Workbook wb = new XSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();
	    Sheet sheet1 = wb.createSheet("Sheet1");
	    Sheet sheet2 = wb.createSheet("Sheet2");
	    Sheet sheet3 = wb.createSheet("Sheet3");
	    
	    Scanner txtInput = new Scanner(txtFile);
	    int i = 0;
	    while (txtInput.hasNextLine()) {
	    	String line = txtInput.nextLine();
	    	RichTextString txtString = createHelper.createRichTextString(line);
	    	Row row = sheet1.createRow(i++);
	    	Cell cell = row.createCell(0);
	    	cell.setCellValue(txtString);
	    }
	    
	    String parentDir = txtFile.getParent();
	    String newLocation = parentDir + "\\" + cutFilename(txtFile) + ".xls";
	    FileOutputStream fileOut = new FileOutputStream(newLocation);
		try {
			
			wb.write(fileOut);
			fileOut.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finished");
	}
	
	public static String cutFilename(File file) {
		String name = file.getName();
		int dot = name.indexOf(".");
		String newName = name.substring(0, dot);
		return newName;
	}
	
	public static String[] processKey(String keyword) {
		//input: " key   word  "
		//output: String[] = {"key", "word"}
		String cleanKey = keyword.trim();
//		cleanKey = cleanKey.replaceAll("\\s+", " ");
		String delimiter = "[ ]+";
		String[] parts = cleanKey.split(delimiter);
		return parts;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("D:\\endResult.txt");//把去重后的txt file object放进 fileToExcel，即在同目录生成excel文件。
//		File dir = new File("F:\\newyear3\\新建文件夹");
//		File[] files = dir.listFiles();
//		for (int i = 0; i < files.length; i++) {
//			System.out.println("Excel " + files[i].getName());
//			fileToExcel(files[i]);
//		}
//		fileToExcel(file);
		String dir = "F:\\newyear4\\Success\\excel";
		File Dir = new File(dir);
		File[] list = Dir.listFiles();
		for (int i = 0; i < list.length; i++) {
//			removeDuplicate(list[i]);
			fileToExcel(list[i]);
		}
	}

}
