package com.example.IT_HRM.Utils;

import com.example.IT_HRM.Entity.Location;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file){

        return TYPE.equals(file.getContentType());
    }

    public static List<Location> excelToLocations(InputStream is){

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Location> locations = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()){
                Row currentRow = rows.next();
                // skip header
                if (rowNumber++ ==0 ) continue;

                Iterator<Cell> cellsInRow = currentRow.iterator();
                Location location = new Location();

                int cellIndex = 0;
                while (cellsInRow.hasNext()){
                    Cell cell = cellsInRow.next();
                    switch (cellIndex){
                        case 0 -> location.setProvince_code(cell.getStringCellValue());
                        case 1 -> location.setProvince_name(cell.getStringCellValue());
                        case 2 -> location.setProvince_kh(cell.getStringCellValue());
                        case 3 -> location.setDistrict_code(cell.getStringCellValue());
                        case 4 -> location.setDistrict_name(cell.getStringCellValue());
                        case 5 -> location.setDistrict_kh(cell.getStringCellValue());
                        case 6 -> location.setCommune_code(cell.getStringCellValue());
                        case 7 -> location.setCommune_name(cell.getStringCellValue());
                        case 8 -> location.setCommune_kh(cell.getStringCellValue());
                        case 9 -> location.setVillage_code(cell.getStringCellValue());
                        case 10 -> location.setVillage_name(cell.getStringCellValue());
                        case 11 -> location.setVillage_kh(cell.getStringCellValue());
                    }
                    cellIndex++;
                }
                locations.add(location);
            }
            workbook.close();

            return locations;
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }
}
