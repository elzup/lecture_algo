package ex09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class linearsearch {
	private final int n = 9999;
	private int[] table = new int[n];
	private static String directory = "./";
	private static String file_name = "sorted.txt";
		//String filename = "reverse.txt";
		//String filename = "sorted.txt";


	public linearsearch(String filename) {
		try {
			// ここを作る

			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String k;
			for (int i = 0; i < n;i++) {
				k = br.readLine();
				this.table[i] = Integer.parseInt(k);
			}

		} catch (FileNotFoundException e) {
			System.out.println(filename + "が見つかりません。");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void search(int key) {
		int loop_num = 0;
		for(int i = 0; i < n; i++) {
			if (key == this.table[i]) {
				System.out.println(i + 1 + "回の探索で" + key + "が見つかりました");
			}
		}
		System.out.println(key + "は見つかりませんでした");
	}

	public void show() {
		// ここを作る
		// 表の要素を全て表示する
		for(int i: this.table)System.out.println(i);
	}

	public static void main(String[] args) {
		// 以下の3行のいずれかを使う
		String filename = linearsearch.directory + linearsearch.file_name;
		linearsearch table = new linearsearch(filename);
//		table.show();
		System.out.println("key=1000を探索");
		table.search(1000);
		System.out.println("key=9412を探索");
		table.search(9412);
		System.out.println("key=2を探索");
		table.search(2);
		System.out.println("key=10000を探索");
		table.search(10000);
	}
}