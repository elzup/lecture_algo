package ex13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QuickSort {
	private final int n = 50000;
	private int[] a = new int[n];

	private String file_path = "src/ex13/data/";

	public QuickSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列aに入れる
		try {
			// ここを作る
			BufferedReader br = new BufferedReader(new FileReader(new File(file_path + filename)));
			String k;
			for (int i = 0; i < n; i++) {
				k = br.readLine();
				this.a[i] = Integer.parseInt(k);
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + "が見つかりません。");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private int partition(int l, int r) {
		// ここを作る
		// クイックソートにおける分割を行う
		return 0;
	}

	private void quicksort(int l, int r) {
		// ここを作る
		// クイックソートを実装する
		// 配列aの中身をソートする
	}

	public void sort() {
		quicksort(0, a.length - 1);
	}

	public void output(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// 配列arrayをファイルに出力する
		// 1行に1レコード
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(file_path + filename))));
			for (int i: this.a) {
				pw.println(i);
			}
			pw.close();
		} catch (IOException e) {
			// TODO catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String file1 = "sorted2.txt";
		String file2 = "rand2_result_quick.txt";

		QuickSort qs = new QuickSort(file1);
		qs.sort();
		qs.output(file2);
		System.out.println("end");
	}
}
