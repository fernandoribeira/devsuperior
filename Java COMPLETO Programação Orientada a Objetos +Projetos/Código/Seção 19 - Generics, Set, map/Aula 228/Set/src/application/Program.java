package application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		
		Set<String> set = new LinkedHashSet<>();
		
		set.add("Tv");
		set.add("Tablet");
		set.add("Notebook");
		
		// set.clear();
		// System.out.println(set.size());
		// set.remove("Tablet");
		// System.out.println(set.contains("Tv"));
		// set.removeIf(x -> x.charAt(0) == 'T');
		
		for (String s : set) {
			System.out.println(s);
		}
		
		
	}
}
