package ex03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	static String FILE_DIR = "./gui/ex03/data/";
	static String FILE_NAME = "english.txt";
	public static void main(String...args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File(FILE_DIR + FILE_NAME)));
		String line;
		HashMap<String, Integer> map = new HashMap<String ,Integer>();
		while((line = bf.readLine()) != null) {
			line = line.replaceAll("[,.\"']", "");
			String[] line_words = line.split(" ");
			for(String s: line_words) {
				if(map.containsKey(s)) {
					int val = map.get(s);
					map.put(s, val + 1);
				} else {
					map.put(s, 1);
				}
			}
		}
		bf.close();
		showEntry(map);
	}

	public static <E, T> void showEntry(Map<E, T> map) {
		System.out.println("【Entry list】");
		for(Map.Entry<E, T> e: map.entrySet())
			System.out.println(e.getKey() + " => " + e.getValue());
		System.out.println();
	}
}
