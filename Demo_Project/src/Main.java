import jxl.Cell;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, WriteException {
       WritableWorkbook workbook = Workbook.createWorkbook(new File("my file.xls"));
        WritableSheet sheet = workbook.createSheet("Sheet 1",0);

        WritableCell cell = new Label( 0,0,"id");
        WritableCell  cell1  = new Label(1,0, "name");
        WritableCell cell2 = new Label (2,0,"roll");

        sheet.addCell(cell);
        sheet.addCell(cell1);
        sheet.addCell(cell2);

        workbook.write();
        workbook.close();
    }
}