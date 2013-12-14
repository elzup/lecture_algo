package ex13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeSort {
	private final int n = 50000;
	private int[] a = new int[n];

	private String file_path = "src/ex13/data/";

	public MergeSort(String filename) {
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

	private void mergesort(int low, int high) {
		// ここを作る
		// マージソートを実装する
		// 配列aの中身をソートする
		assert low >= 0 && high >= 0;
		int n = high - low + 1;
		if (n <= 1) return ;
		if (n == 2) {
			if (a[high] < a[low]) {
				int t = a[high];
				a[high] = a[low];
				a[low] = t;
			}
			return;
		}
		int mid = (high + low) / 2;
		this.mergesort(low, mid);
		this.mergesort(mid + 1, high);
		int lp = 0, hp = 0;
		int[] la = new int[mid - low + 1];
		int[] ha = new int[high - mid];
		for (int i = 0; i < la.length; i++) {
			la[i] = a[low + i];
		}
		for (int i = 0; i < ha.length; i++) {
			ha[i] = a[mid + 1 + i];
		}
		for (int i = low; i <= high; i++) {
			if (hp == ha.length || (lp < la.length && la[lp] < ha[hp]))
				a[i] = la[lp++];
			else
				a[i] = ha[hp++];
		}
	}

	public void sort() {
		mergesort(0, a.length - 1);
	}

	public void output(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// 配列aをファイルに出力する
		// 1行に1レコード
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(file_path + filename))));
			for (int i : this.a) {
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
		String file2 = "rand2_merge.txt";

		MergeSort ms = new MergeSort(file1);
		ms.sort();
		ms.output(file2);
	}
}
