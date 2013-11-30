package ex05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WordSorter_y {
	static String FILE_DIR = "./algo/ex05/data/english.txt";
	public static void main(String[] args) {
		ArrayList<String>word = new ArrayList<String>();

		String filename = FILE_DIR;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(" ");
				for (int i = 0; i < data.length; i++) {
					word.add(data[i]);
				}
//				Collections.sort(word);
//				System.out.println(word);

			}
				Collections.sort(word);
				for(String mo :word)System.out.println(mo);

			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println(filename + "が見つかりません。");
		} catch (IOException e) {
			System.out.println(e);
		}


	}
}
