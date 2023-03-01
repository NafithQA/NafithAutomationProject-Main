package org.nafeth.helpers;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelHandler {

    public static void main(String[] args) {

        ExcelHandler excelHandler = new ExcelHandler();
    }

//    public Pair getUserAndPass(String hasTruck, String hasEquipment, String hasAffilication, String hasSubscription, String truckType) {
//
//        FileInputStream file = null;
//        try {
//            file = new FileInputStream(new File(System.getProperty("user.dir")
//                    + File.separator + "src" + File.separator + "main" + File.separator + "resources"
//                    + File.separator + "testData" + File.separator + "subscriptionData.xlsx"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Create Workbook instance holding reference to .xlsx file
//        XSSFWorkbook workbook = null;
//        try {
//            workbook = new XSSFWorkbook(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Get first/desired sheet from the workbook
//        XSSFSheet sheet = workbook.getSheetAt(2);
//
//        int truckColumn = 4;
//        int equipmentColumn = 5;
//        int affilicationColumn = 6;
//        int subscriptionsColumn = 7;
//        int rowIndex = 1;
//        int userNameColumn = 9;
//        int passwordColumn = 10;
//        int truckTypeColumn = 11;
//
//        String userName = null;
//        int password = 0;
//
//        for (int i = sheet.getPhysicalNumberOfRows(); i >= 0; i--) {
//
//            Row row = CellUtil.getRow(rowIndex, sheet);
//            Cell truckCell = CellUtil.getCell(row, truckColumn);
//            Cell equipmentCell = CellUtil.getCell(row, equipmentColumn);
//            Cell affilicationCell = CellUtil.getCell(row, affilicationColumn);
//            Cell subscriptionsCell = CellUtil.getCell(row, subscriptionsColumn);
//            Cell truckTypeCell = CellUtil.getCell(row, truckTypeColumn);
//            Cell userNameCell = CellUtil.getCell(row, userNameColumn);
//            Cell passwordCell = CellUtil.getCell(row, passwordColumn);
//            String userNameValue = userNameCell.getStringCellValue();
//            int passwordValue = (int) passwordCell.getNumericCellValue();
//
//            if (truckCell.getStringCellValue().equalsIgnoreCase(hasTruck)
//                    && equipmentCell.getStringCellValue().equalsIgnoreCase(hasEquipment)
//                    && affilicationCell.getStringCellValue().equalsIgnoreCase(hasAffilication)
//                    && subscriptionsCell.getStringCellValue().equalsIgnoreCase(hasSubscription)
//                    && truckTypeCell.getStringCellValue().equalsIgnoreCase(truckType)) {
//
//                userName = userNameValue;
//                password = passwordValue;
//                break;
//
//            } else {
//                rowIndex++;
//            }
//        }
//        try {
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new Pair<String, Integer>(userName, password);
//    }

    public String getValidRNN() {

        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(System.getProperty("user.dir")
                    + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                    + File.separator + "testData" + File.separator + "subscriptionData.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(4);

        int rnnColumn = 0;
        int statusColumn = 1;
        int rowIndex = 1;

        long rnn = 0;
        long rnnValue = 0;

        for (int i = sheet.getPhysicalNumberOfRows(); i >= 0; i--) {

            Row row = CellUtil.getRow(rowIndex, sheet);
            Cell rnnCell = CellUtil.getCell(row, rnnColumn);
            Cell statusCell = CellUtil.getCell(row, statusColumn);

            rnnValue = (long) rnnCell.getNumericCellValue();

            if (statusCell.getStringCellValue().equalsIgnoreCase("Unused")) {

                rnn = rnnValue;
                break;

            } else {
                rowIndex++;
            }
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String stringRNN = String.valueOf(rnn);
        return stringRNN;
    }

    public void writeDataOnExcel(ArrayList<String> arrayList) {

        File xlsxFile = new File(System.getProperty("user.dir")
                + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "testData" + File.separator + "queriesData.xlsx");

        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);

            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);

            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("Count of testCaseQueryResultSet : " + arrayList.size());
            //Iterating student informations
            for (int i = 0; i < arrayList.size(); i++) {

                //Creating new cell and setting the value
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(arrayList.get(i));
            }

            //Close input stream
            inputStream.close();

            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            //Close the workbook and output stream
            workbook.close();
            os.close();

            System.out.println("Excel file has been updated successfully.");

        } catch (EncryptedDocumentException |
                IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
    }

    public void clearDataFromExcel(ArrayList<String> arrayList) {

        File xlsxFile = new File(System.getProperty("user.dir")
                + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + "testData" + File.separator + "queriesData.xlsx");

        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);
            ZipSecureFile.setMinInflateRatio(0);

            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);

            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(0);

            //Iterating student informations
            for (int i = 0; i < arrayList.size(); i++) {

                //Creating new cell and setting the value
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setBlank();
            }

            //Close input stream
            inputStream.close();

            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            //Close the workbook and output stream
            workbook.close();
            os.close();

            System.out.println("Excel Data has been Cleared successfully.");

        } catch (EncryptedDocumentException |
                IOException e) {
            System.err.println("Exception while Clearing an existing excel file.");
            e.printStackTrace();
        }
    }

    public String[][] getQueriesExcelData(String filePath, String sheetName) throws IOException {
        String[][] data = null;
        try {

            FileInputStream fis = new FileInputStream(filePath);
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            System.out.println("No of rows is : " + noOfRows);
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows][noOfCols];

            for (int i = 0; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Cell> getQueriesData() {

        ArrayList<Cell> list = new ArrayList<Cell>();

        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\lenovo\\Desktop\\queriesData.xlsx"));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    list.add(cell);
                }
            }
            workbook.close();
            file.close();

        } catch (IOException e) {
        }

        return list;
    }
}
