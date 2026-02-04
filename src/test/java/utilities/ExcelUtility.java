package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileInputStream fi;
	public FileOutputStream fo;
	public CellStyle style;
	String path;
	String data;
	
	ExcelUtility(String path){
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fi=new FileInputStream(path);
		
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName,int rowNum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		//int rowCount=sheet.getLastRowNum();
		row=sheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName,int rowNum,int cellNum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		DataFormatter df=new DataFormatter();
		
		try {
		data=df.formatCellValue(cell);	
		}catch(Exception e) {
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetName,int rownum,int cellNum,String data) throws IOException {
		File xlFile=new File(path);
		if(!xlFile.exists()) {
				workbook= new XSSFWorkbook();
				fo=new FileOutputStream(path);
				workbook.write(fo);
				}
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1) {//if sheet not exists then create new sheet
			workbook.createSheet(sheetName);
			sheet=workbook.getSheet(sheetName);
		}
		
		if(sheet.getRow(rownum)==null) {//if row not exists then create new row
			sheet.createRow(rownum);
			row=sheet.getRow(rownum);
		}
		
		cell=row.createCell(cellNum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public void fillGreenColor(String sheetName,int rowNum,int colNum) throws IOException {
			fi=new FileInputStream(path);
			workbook= new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			style=workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
			
	}
	
	public void fillRedColor(String sheetName,int rowNum,int colNum) throws IOException {
		fi=new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
}
}
