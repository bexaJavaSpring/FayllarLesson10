package uz.pdp.homework.task3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Photo>photos=new ArrayList<>();
    public static void complete(){
        ObjectMapper objectMapper=new ObjectMapper();
        String url="src/main/resources";

        try {
            Database.photos=objectMapper.readValue(new File(url, "photos.json"), new TypeReference<List<Photo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
