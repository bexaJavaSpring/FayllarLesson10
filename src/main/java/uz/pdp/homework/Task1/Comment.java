package uz.pdp.homework.Task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
	private int postId;
	private int id;
	private String name;

	private String body;
	private String email;



}