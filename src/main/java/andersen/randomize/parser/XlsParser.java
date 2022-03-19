package andersen.randomize.parser;

import andersen.randomize.entity.Student;
import andersen.randomize.entity.Team;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

public class XlsParser {


    {
        Workbook wb = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\Daria\\Desktop\\students.xls"));
        } catch (IOException ex) {
            Logger.getLogger(ex.toString());
        }

        HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        Student student = new Student();
        Team team = new Team();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        student.setName(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        team.setId((int) cell.getNumericCellValue());
                        student.setTeam(team);
                        break;
                    case BOOLEAN:
                        student.setCaptain(Boolean.parseBoolean(Boolean.toString(cell.getBooleanCellValue())));
                        break;
                    default:
                        break;
                }
            }
            Logger.getLogger("Student \n" + student + "  ");
        }
    }
}