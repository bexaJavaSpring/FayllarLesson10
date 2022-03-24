package uz.pdp.homework.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Photo {
 private Integer albumId;
 private Integer id;
 private String title;
 private String url;
 private String thumbnailUrl;

}
