package uz.pdp.homework.Task2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Post>posts=new ArrayList<>();
  public static void complete() {


    ObjectMapper objectMapper = new ObjectMapper();
    String url = "src/main/resources";

    try {
        Database.posts = objectMapper.readValue(new File(url, "posts.json"), new TypeReference<List<Post>>() {

        });
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
