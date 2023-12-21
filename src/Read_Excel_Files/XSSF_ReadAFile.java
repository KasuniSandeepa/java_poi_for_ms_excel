/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Read_Excel_Files;

import Models.GnDivision;
import Models.GnDivisionNameComparator;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author NCCS
 */
public class XSSF_ReadAFile {

    private static final String XLSX_FILE_PATH
//            = "C:\\Users\\NCCS\\Downloads\\GN-List-Kandy.xlsx";
//            ="C:\\Users\\NCCS\\Downloads\\GN-List-Matale.xlsx";
//            = "C:\\Users\\NCCS\\Downloads\\GN-List-Nuwara-Eliya.xlsx";
//            = "C:\\Users\\NCCS\\Downloads\\GN-List-Colombo.xlsx";
//            = "C:\\Users\\NCCS\\Downloads\\GN-List-Gampaha.xlsx";
//            = "C:\\Users\\NCCS\\Downloads\\GN-List-Kalutara.xlsx";
//            = "C:\\Users\\NCCS\\Downloads\\GN-List-Kurunegala.xlsx";
            = "D:\\D\\Mobios Private Limited\\Kenko First\\Sri-Lanka-GN-Divisions\\GN-List-Kalutara.xlsx";

    private static List<GnDivision> GnList = new LinkedList<>();

    public static void main(String[] args) {
        ExcelFileRead();
    }

    private static void ExcelFileRead() {

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

//        System.out.println("Iterating rows and columns ...");
        //Traversing over each row of XLSX file
        Iterator<Row> rowIterator = sheet.iterator();
        int i = 0;
        //--
        GnList.clear();
        while (rowIterator.hasNext()) {
//            i++;
//            if (i == 10) {
//                break;
//            }
            //For each row, iterate through each columns
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = null;
            String sinhala = "", tamil = "", english = "";
            String gnCode = "";
            String province = "", district = "", divisionalSecretariat = "";
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                //You will have your columns fixed in Excel file
//                System.out.println("column index: " + cell.getColumnIndex());
                switch (cell.getColumnIndex()) {
                    case 1:
                        gnCode = dataFormatter.formatCellValue(cell);
                        break;
                    case 2:
                        sinhala = dataFormatter.formatCellValue(cell);
                        break;
                    case 3:
                        tamil = dataFormatter.formatCellValue(cell);
                        break;
                    case 4:
                        english = dataFormatter.formatCellValue(cell);
                        break;
                    case 6:
                        province = dataFormatter.formatCellValue(cell);
                        break;
                    case 7:
                        district = dataFormatter.formatCellValue(cell);
                        break;
                    case 8:
                        divisionalSecretariat = dataFormatter.formatCellValue(cell);
                        break;
                }

            }
//            System.out.println(sinhala + " " + tamil + " " + english
//                    + " " + province + " " + district + " "
//                    + divisionalSecretariat);
//            System.out.println(sinhala + " " + tamil + " " + english);
//            System.out.println("[\"" + english + "\",\"" + sinhala + "\",\""
//                    + tamil + "\"],");
            GnList.add(new GnDivision(english, sinhala, tamil, gnCode));
            /*
             ["Hadirawalana Ihala","හදිරවලන ඉහල", "அனுராதபுரம்"],
             */
        }

        //--close the workbook
        try {
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--
        GnListTraverse();

    }

    private static void GnListTraverse() {

        //--sort list
        Collections.sort(GnList, new GnDivisionNameComparator());
        for (GnDivision g : GnList) {
            System.out.println("[\"" + g.getGnCode() + " - "+g.getEnglish()
                    + "\",\"" + g.getGnCode() + " - " + g.getSinhala()
                    + "\",\"" +  g.getGnCode() + " - "+  g.getTamil() + "\"],");
        }

    }

}
