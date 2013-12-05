package ex12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SelectionSort {
	private final int n = 50000;
	private int[] array = new int[n];

	private String file_path = "src/ex12/data/";

	public SelectionSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列arrayに入れる
		try {
			// ここを作る
			BufferedReader br = new BufferedReader(new FileReader(new File(file_path + filename)));
			String k;
			for (int i = 0; i < n; i++) {
				k = br.readLine();
				this.array[i] = Integer.parseInt(k);
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + "が見つかりません。");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void sort() {
		// ここを作る
		// 選択ソートを実装する
		// 配列arrayの中身をソートする
		for (int i = 0; i < n; i++) {
			int min_index = i;
			for (int j = i + 1; j < n; j++)
				if (array[min_index] > array[j]) min_index = j;
			int t = array[i];
			array[i] = array[min_index];
			array[min_index] = t;
		}
	}

	public void output(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// 配列arrayをファイルに出力する
		// 1行に1レコード
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(file_path + filename))));
			for (int i : this.array) {
				pw.println(i);
			}
			pw.close();
		} catch (IOException e) {
			// TODO catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "rand2_result_sel.txt";

		SelectionSort ss = new SelectionSort(file1);
		ss.sort();
		ss.output(file2);
		System.out.println("end");
	}
}
