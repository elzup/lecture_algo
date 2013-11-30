package ex09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class binarysearch {
	private final int n = 9999;
	private int[] table = new int[n];

	private static String input_directory = "./src/ex09/data/";
	private static String file_name = "rand.txt";

	public binarysearch(String filename) {
		try {
			// ここを作る
			boolean sorted = true;
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String k;
			for (int i = 0; i < n; i++) {
				k = br.readLine();
				this.table[i] = Integer.parseInt(k);
				if (sorted && i != 0 && this.table[i - 1] > this.table[i]) sorted = false;
			}
			if (!sorted)
				Arrays.sort(this.table);		//ソート
		} catch (FileNotFoundException e) {
			System.out.println(filename + "が見つかりません。");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void search(int key) {
		// ここを作る
		// 二分探索でkeyを探す
		int book_f = 0;
		int book_e = n;
		int loop_n = 0;

		while (book_f + 1 < book_e) {
			int book_m = (book_e + book_f) / 2;
			loop_n++;
			if (book_m == key ) {
				System.out.println(loop_n + "回の探索で" + key + "が見つかりました");
				return;
			}
			if (book_m < key)
				book_f = book_m;
			else
				book_e = book_m;
		}
		System.out.println(loop_n + "回探索しましたが" + key + "は見つかりませんでした");
	}

	public void show() {
		// ここを作る
		// 表の要素を全て表示する
		for(int i: this.table)System.out.println(i);
	}

	public static void main(String[] args) {
		String filename = input_directory + file_name;
		binarysearch table = new binarysearch(filename);

		table.show();
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
