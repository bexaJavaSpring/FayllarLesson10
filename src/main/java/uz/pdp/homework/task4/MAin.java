package uz.pdp.homework.task4;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MAin {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            String path = "src/main/resources";
            File file = new File(path, "USER.pdf");
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            PdfWriter pdfWriter = new PdfWriter(file);
            PdfDocument document = new PdfDocument(pdfWriter);
            Document document1 = new Document(document);
            Paragraph paragraph = new Paragraph("USERS:");
            paragraph.setTextAlignment(TextAlignment.CENTER);
            paragraph.setFontSize(22);
            paragraph.setBold();
            document1.add(paragraph);
            float[] colums = {100, 150, 100, 100, 300,400,400,};
            Table table = new Table(colums);
            table.addCell("lastName");
            table.addCell("firstName");
            table.addCell("fathersName");
            table.addCell("region");
            table.addCell("passport_number");
            table.addCell("inn");
            table.addCell("person");
            System.out.println("Pasport raqamini kiriting:");
            String passportNumber=scanner.nextLine();
         for(User user:Database.users){
             if(user.getPassport_number().toLowerCase().equals(passportNumber.toLowerCase())){
                 table.addCell(user.getLastName());
                 table.addCell(user.getFirstName());
                 table.addCell(user.getFathersName());
                 table.addCell(user.getRegion());
                 table.addCell(user.getPassport_number());
                 table.addCell(user.getInn()+"");
                 table.addCell(user.getPerson()+"");
             }
         }

         document1.add(table);

            Desktop.getDesktop().open(file);
          document1.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
