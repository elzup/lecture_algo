package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WordSorter {

	static String FILE_DIR = "./algo/ex05/data/";
	static String FILE_NAME = "english.txt";
	static String REG_PLANE = "([,\"'()])";

	static String REG_ENDPL = "([a-zA-Z])[.]";
	static String REG_ENDPL_TO = "$1";

	public static void main(String...args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File(FILE_DIR + FILE_NAME)));
		String line;
		ArrayList<String> list = new ArrayList<String>();
		while((line = bf.readLine()) != null) {
			line = line.replaceAll(REG_PLANE, "");
			line = line.replaceAll(REG_ENDPL, REG_ENDPL_TO);
			String[] line_words = line.split(" ");
			for(String s: line_words) {
//				if(!list.contains(s))
					list.add(s);
			}
		}
		bf.close();
		Collections.sort(list);
		showEntry(list);
	}

	public static void showEntry(Collection co) {
		System.out.println("【Entry list】");
		for(Object o: co) {
			System.out.println(o);
		}
	}
}
