package com.ponsun.aml.banktransaction.infrastructure.fileupload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class XlsFileParser implements FileParser {

    private final String fileName;

    private final String directoryPath;

    public XlsFileParser(String directoryPath, String fileName) {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
    }

    @Override
    public List<Map<String, Object>> parseRecordTable() {
        log.debug("Start of parseRecordTable()");
        List<Map<String, Object>> results = new ArrayList<>();
        File xlsFile;
        FileInputStream fis = null;
        try {

            xlsFile = new File(this.directoryPath + File.separator + fileName);
            fis = new FileInputStream(xlsFile);
//             fis = OPCPackage.open(new File(this.directoryPath + File.separator + fileName));
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mySheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Skip header
                if (row.getRowNum() == 0) {
                    continue;
                }
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                final Map<String, Object> resultData = new HashMap<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Example format: two decimal places
                    //System.out.println(cell.getCellType());

//                    if (0 == cell.getColumnIndex()) {
//                        if (cell.getCellType().name().equals("STRING")) {
//                            resultData.put("name", cell.getStringCellValue());
//                        }
//                        if (cell.getCellType().name().equals("DOUBLE")) {
//                            resultData.put("name", Double.valueOf(cell.getNumericCellValue()));
//                        }
//                        if (cell.getCellType().name().equals("NUMERIC")) {
//                            resultData.put("name", String.valueOf(cell.getNumericCellValue()));
//                        }
//                    }
                    if (0 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {

                        DataFormatter dataFormatter = new DataFormatter();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("TransactionDate", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("TransactionDate", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            //System.out.println(dataFormatter.formatCellValue(cell.getDateCellValue().getTime()));
                            //System.out.println(cell.getDateCellValue().getDate()+"-"+cell.getDateCellValue().getMonth()+"-"+cell.getDateCellValue().getYear());
                            String formattedValue = dataFormatter.formatCellValue(cell);
                            resultData.put("TransactionDate", formattedValue);
                        }

                    }
                    if (1 == cell.getColumnIndex()  && !cell.getCellType().name().isEmpty()) {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Sender Customer ID", cell.getStringCellValue());
                            System.out.println("A"+cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Sender Customer ID", Double.valueOf(cell.getNumericCellValue()));
                            System.out.println("B"+cell.getNumericCellValue());
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("Sender Customer ID", formattedValue);
                            //System.out.println("C"+formattedValue);
                        }
                    }
                    if (2 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty()) {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Sender Account", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Sender Account", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("Sender Account", formattedValue);
                        }
                    }

                    if (3 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty()) {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Sender Name", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Sender Name", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("Sender Name", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    if (4 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty()) {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Sender Bank Name", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Sender Bank Name", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("Sender Bank Name", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    if (5 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty()) {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Country", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Country", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("Country", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    if (6 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty()) {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Receiver Customer ID", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Receiver Customer ID", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("Receiver Customer ID", formattedValue);
                        }
                    }

                    if (7 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("ReceiverAccount", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("ReceiverAccount", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("ReceiverAccount", formattedValue);
                        }
                    }
                    if (8 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Receiver", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Receiver", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("Receiver", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    if (9 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Receiver Bank Name", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Receiver Bank Name", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("Receiver Bank Name", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    if (10 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {
                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("ReceiverCountry", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("ReceiverCountry", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("ReceiverCountry", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
//
                    if (11 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {

                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Description", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Description", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            resultData.put("Description", String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                    if (12 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {

                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Deposits", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Deposits", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("Deposits", formattedValue);
                        }
                    }
                    if (13 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {

                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Withdrawls", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Withdrawls", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("Withdrawls", formattedValue);
                        }
                    }
                    if (14 == cell.getColumnIndex() && !cell.getCellType().name().isEmpty())  {

                        if (cell.getCellType().name().equals("STRING")) {
                            resultData.put("Balance", cell.getStringCellValue());
                        }
                        if (cell.getCellType().name().equals("DOUBLE")) {
                            resultData.put("Balance", Double.valueOf(cell.getNumericCellValue()));
                        }
                        if (cell.getCellType().name().equals("NUMERIC")) {
                            double numericValue = cell.getNumericCellValue();
                            String formattedValue = decimalFormat.format(numericValue);
                            resultData.put("Balance", formattedValue);
                        }
                    }
                }
                log.debug("END of parseRecordTable()");
                results.add(resultData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error while parsing file data {} ", e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
