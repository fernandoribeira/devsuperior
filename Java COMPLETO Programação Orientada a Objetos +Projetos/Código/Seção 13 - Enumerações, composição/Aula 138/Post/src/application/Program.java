package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Post;
import entities.Comment;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date moment;
		String title;
		String content;
		Integer likes;
		
		moment = sdf.parse("21/06/2018 13:05:44");
		title = "Traveling to New Zealand";
		content = "I'm going to visit this wonderful country!";
		likes = 12;
			
		Post p1 = new Post(moment, title, content, likes);
		p1.addComment(new Comment("Have a nice trip"));
		p1.addComment(new Comment("Wow that's awesone!"));
		
		moment = sdf.parse("28/07/2018 23:14:19");
		title = "Good night guys";
		content = "See you tomorrow";
		likes = 5;
		
		Post p2 = new Post(moment, title, content, likes);
		p2.addComment(new Comment("Good night"));
		p2.addComment(new Comment("May the Force be with you"));
		
		System.out.println(p1);
		System.out.println(p2);

	}
}
