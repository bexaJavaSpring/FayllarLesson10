package uz.pdp.homework.Task2;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Database.complete();
        String path="src/main/resources";
        File file=new File(path,"POST.xlsx");
        file.createNewFile();
        XSSFWorkbook workbook=new XSSFWorkbook();
        FileOutputStream out=new FileOutputStream(file);
        XSSFSheet sheet=workbook.createSheet("POSTS");
     sheet.setColumnWidth(0,10*128);
     sheet.setColumnWidth(1,10*256);
     sheet.setColumnWidth(2,80*256);
     sheet.setColumnWidth(3,80*256);
        XSSFRow row=sheet.createRow(0);
    row.createCell(0).setCellValue("UserId");
    row.createCell(1).setCellValue("Id");
    row.createCell(2).setCellValue("Title");
    row.createCell(3).setCellValue("Body");
for(int i=0;i<Database.posts.size();i++) {
    Post post = Database.posts.get(i);
    XSSFRow row1 = sheet.createRow(i + 1);
    row1.createCell(0).setCellValue(post.getUserId());
    row1.createCell(1).setCellValue(post.getId());
    row1.createCell(2).setCellValue(post.getTitle());
    row1.createCell(3).setCellValue(post.getBody());
}
try {
    InputStream inputStream = new FileInputStream("src/main/resources/image.png");
    byte[] bytes = IOUtils.toByteArray(inputStream);
    int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
    inputStream.close();
    XSSFDrawing helper = sheet.createDrawingPatriarch();
    XSSFAnchor anchor = helper.createAnchor(30, 40, 50, 60, 2, 105, 8, 120);
    Picture picture = helper.createPicture((ClientAnchor) anchor, pictureIdx);
    picture.resize();
    FileOutputStream fileOutputStream = null;
    fileOutputStream = new FileOutputStream(file);
    workbook.write(fileOutputStream);

    }catch (Exception e){
    System.out.println(e);
}



        workbook.write(out);
        out.close();
        workbook.close();
        Desktop.getDesktop().open(file);
        System.out.println("Finish");
    }
}
