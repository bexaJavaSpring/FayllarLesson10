package uz.pdp.homework.Task1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Comment>comments=new ArrayList<>();
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper=new ObjectMapper();
        String path="src/main/resources";
        try {
           comments=objectMapper.readValue(new File(path, "comments.json"), new TypeReference<List<Comment>>() {});
        }catch (IOException e){
            e.printStackTrace();
        }
        String path1="src/main/resources";
        File file=new File(path1,"ROYXAT.docx");
        file.createNewFile();
        XWPFDocument document=new XWPFDocument();
        FileOutputStream out=new FileOutputStream(file);
        XWPFParagraph paragraph=document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run=paragraph.createRun();
        run.setText("Ro'yxat");
        run.setBold(true);
        XWPFTable table=document.createTable(1,6);
        table.setWidth("100%");
        XWPFTableRow tableRow=table.getRow(0);
        XWPFTableCell cell=tableRow.getCell(1);
        cell.setWidth("15%");
        cell.setText("PostId");
        XWPFTableCell cell1=tableRow.getCell(2);
     cell1.setWidth("10%");
     cell1.setText("ID");
        XWPFTableCell cell2=tableRow.getCell(3);
    cell2.setWidth("30%");
    cell2.setText("Name");
        XWPFTableCell cell3=tableRow.getCell(4);
     cell3.setWidth("30%");
     cell3.setText("Body");
        XWPFTableCell cell4=tableRow.getCell(5);
      cell4.setWidth("35%");
      cell4.setText("Email");
          for(Comment comment:comments){
              XWPFTableRow tableRow1=table.createRow();

              tableRow1.getCell(1).setText(String.valueOf(comment.getPostId()));
              tableRow1.getCell(2).setText(String.valueOf(comment.getId()));
              tableRow1.getCell(3).setText(comment.getName());
              tableRow1.getCell(4).setText(comment.getBody());
              tableRow1.getCell(5).setText(comment.getEmail());
          }
          document.write(out);
          out.close();
          document.close();
        Desktop.getDesktop().open(file);
        System.out.println("Finish");
    }
}
