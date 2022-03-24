package uz.pdp.homework.task3;

import com.google.zxing.pdf417.PDF417Writer;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Database.complete();
        try {
            String path = "src/main/resources";
            File file = new File(path, "photos.pdf");
            file.createNewFile();
            PdfWriter writer = new PdfWriter(file);
            PdfDocument document = new PdfDocument(writer);
            Document document1 = new Document(document);
            Paragraph paragraph = new Paragraph("PHOTOS:");
            paragraph.setTextAlignment(TextAlignment.CENTER);
            paragraph.setBold();
            paragraph.setFontSize(22);

            document1.add(paragraph);
            float[] colums = {50, 50, 50, 100, 100};
            Table table = new Table(colums);
            table.addCell("AlbumId");
            table.addCell("Id");
            table.addCell("Title");
            table.addCell("Url");
            table.addCell("thumbnailUrl");
            for (Photo photo : Database.photos) {
                table.addCell(photo.getAlbumId() + "");
                table.addCell(photo.getId() + "");
                table.addCell(photo.getTitle());
                table.addCell(photo.getUrl());
                table.addCell(photo.getThumbnailUrl());
            }
            document1.add(table);
            Desktop.getDesktop().open(file);
            document1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
