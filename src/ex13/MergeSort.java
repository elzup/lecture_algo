package ex13;

import ex12.Sort;


public class MergeSort extends Sort {
	private final int n = 50000;
	private int[] a = new int[n];

	private static String FILE_PATH = "src/ex13/data/";

	public MergeSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列aに入れる
		super(filename, FILE_PATH);
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

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "rand2_result_merge.txt";

		MergeSort ms = new MergeSort(file1);
		ms.sort();
		ms.output(file2);
	}
}
