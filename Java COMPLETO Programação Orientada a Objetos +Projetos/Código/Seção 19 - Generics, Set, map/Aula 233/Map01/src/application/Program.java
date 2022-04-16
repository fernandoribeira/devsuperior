package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {
	public static void main(String[] args) {
		
		Map<String, String> cookies = new TreeMap<>();
		
		cookies.put("username", "maria");
		cookies.put("email", "mari@gmail.com");
		cookies.put("phone", "984516263");
		
		System.out.println(cookies);
		
		cookies.remove("email");
		cookies.put("phone", "123456");
		
		System.out.println(cookies);
		
		System.out.println("Contain pohne key: " + cookies.containsKey("phone"));
		System.out.println("Phone number: " + cookies.get("phone"));
		System.out.println("Email: " + cookies.get("email"));
		System.out.println("Size: " + cookies.size());
		
		System.out.println("All cookies:");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
		
	}
}
