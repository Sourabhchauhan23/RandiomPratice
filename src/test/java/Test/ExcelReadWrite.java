package Test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;


public class ExcelReadWrite {


    public  String path;
    public FileInputStream fis = null;
    public FileOutputStream fileOut =null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row   =null;
    private XSSFCell cell = null;

    public Logger log = null;

    public static void main(String[] args) throws IOException {

        String path1 = System.getProperty("user.dir");
        String path2 = "\\src\\test\\resources\\TestData.xlsx";
        String path3 = path1+path2;

    //    ExcelReadWrite read = new ExcelReadWrite(path);
        ExcelReadWrite read = new ExcelReadWrite(
                System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx");
        List<ExcelPojo> workersss=read.LoadDataFromExcel(path3);
        read.PrintExcelPojoData(workersss);


    }

    public ExcelReadWrite(String path) {

        this.path=path;
        try {
            log = Logger.getLogger(String.valueOf(ExcelReadWrite.class));
            fis = new FileInputStream(path);
//            System.out.println(fis.toString());
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


    public List<ExcelPojo> LoadDataFromExcel(String path) throws FileNotFoundException, IOException {
        workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
        Iterator iterator = workbook.getSheetAt(0).iterator();

        List<ExcelPojo> workerss = new ArrayList<>();

        while (iterator.hasNext()){
            ExcelPojo worker = new ExcelPojo();
            Row currentRow = (Row) iterator.next();

            if(currentRow.getRowNum()==0){
                continue;
            }

            ExcelPojo workers = new ExcelPojo();

            Iterator<Cell> cellIterator = currentRow.iterator();

            while(cellIterator.hasNext()){

                Cell currentCell = cellIterator.next();
                CellAddress address = currentCell.getAddress();

                if(address.getColumn()==0){
                    workers.setName(currentCell.getStringCellValue());
                } else if (address.getColumn()==1) {
                    workers.setId(Double.valueOf(currentCell.getNumericCellValue()));
                } else if (address.getColumn()==2) {
                    workers.setJob(currentCell.getStringCellValue());
                }
            }
            workerss.add(workers);
        }
        return workerss;

    }

    public void PrintExcelPojoData(List<ExcelPojo> excelPojo){

        excelPojo.stream().forEach(x -> System.out.println("My name is " + x.getName() + ". My Id is " + x.getId() +
                ". My Job is " + x.getJob() + "."));
    }


}
