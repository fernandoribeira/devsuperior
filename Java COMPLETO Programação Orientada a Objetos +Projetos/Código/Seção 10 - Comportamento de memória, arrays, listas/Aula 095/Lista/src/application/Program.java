package application;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("Bolacha");
		list.add("Minhoca");
		list.add("Gabriel");
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		System.out.println(list.size());
		System.out.println();
		
		list.add("Xuxu");
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		list.add(2, "Ual");
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		list.remove("Ual");
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		list.remove(1);
		for (String name : list) {
			System.out.println(name);
		}
		System.out.println();
		
		System.out.println(list.get(0));
		
	}
}
