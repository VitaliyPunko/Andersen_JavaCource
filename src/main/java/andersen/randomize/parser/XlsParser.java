package andersen.randomize.parser;



import andersen.randomize.controller.LessonController;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;



public class XlsParser {

    private String file = "";
    public static Logger LOGGER = LoggerFactory.getLogger(XlsParser.class);

    Workbook workbook;

    {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            workbook = new HSSFWorkbook(new FileInputStream(String.valueOf(fileInputStream)));
            for (Row row: workbook.getSheetAt(0)){
                for (Cell cell: row){
                   LOGGER.debug(getCell(cell));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getCell(Cell cell) {
        String res ="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");

        switch (cell.getCellType()) {
            case STRING:
                res= cell.getRichStringCellValue().getString().toString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    res =sdf.format(cell.getDateCellValue().toString()) ;
                } else {
                    res =Double.toString(cell.getNumericCellValue()) ;
                }
                break;
            case BOOLEAN:
                res = Boolean.toString(cell.getBooleanCellValue());
                break;
            default:
               break;
        }
        return res;
    }

}
