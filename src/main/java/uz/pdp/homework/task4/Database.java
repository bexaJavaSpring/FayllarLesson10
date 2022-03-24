package uz.pdp.homework.task4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Database {
      public static List<User>users=new ArrayList<>(
              Arrays.asList(new User("Behruz","Izzatullayev","Qahramon","Buxoro tuman","AC102334",(long)(Math.random()*1000000000),Person.LAWYER_PERSON),
                      new User("Mirjon","Ramazonov","Rustam","Lelizim tumani","AB2434334",(long)(Math.random()*1000000000)+1,Person.BODILY_PERSON),
                      new User("Alisher","Bahodirov","Tolmas","Marhamat tumani","AB4444444",(long)(Math.random()*1000000000)+2,Person.BODILY_PERSON),
                      new User("Anvar","Umidov","Akobir","Yunusobod tumani","AC3243434",(long)(Math.random()*1000000000)+3,Person.BODILY_PERSON),
                      new User("Sardor","Po'latov","Erkin","Nishon tumani","AC000000",(long)(Math.random()*1000000000)+4,Person.BODILY_PERSON),
                      new User("Sardor","Po'latov","Erkin","Nishon tumani","AC000000",(long)(Math.random()*1000000000)+4,Person.BODILY_PERSON),
                      new User("Yunus","Isakulov","Sardor","Jondor tumani","AC3243434",(long)(Math.random()*1000000000)+6,Person.LAWYER_PERSON),
                      new User("Asadbek","To'lqinov","Rajab","Shaxriston tumani","AB23424334",(long)(Math.random()*1000000000)+7,Person.BODILY_PERSON),
                      new User("Javohir","Avlayev","Shaxzod","Vobkent tumani","AB000000",(long)(Math.random()*1000000000)+8,Person.LAWYER_PERSON),
                      new User("Nurbek","Iskandarov","Otabek","Rometan tumani","AC2321111",(long)(Math.random()*1000000000)+9,Person.BODILY_PERSON)));

}
