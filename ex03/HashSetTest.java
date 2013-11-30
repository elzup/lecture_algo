package ex03;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String...args) {
		HashSet<String> set = new HashSet<String>();
		String[] strs = {"Alice", "Bob", "Charlie", "Diana", "Elmo", "Fred", "Bob"};
//		String[] strs = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "a"};
		for(String s: strs) set.add(s);

		System.out.println(set);
	}
}
