package ex13;

import ex12.Sort;

public class QuickSort extends Sort{
	private final int n = 50000;
	private int[] a = new int[n];

	private static String FILE_PATH = "src/ex13/data/";

	public QuickSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列aに入れる
		super(filename, FILE_PATH);
	}

	private int partition(int l, int r) {
		// ここを作る
		// クイックソートにおける分割を行う
		int pivot_value = a[r];
		int ps = l;
		int pe = r - 1;
		int pivot = 0;
		if (r - l == 1)
			pivot = (a[l] > a[r] ? l : r);
		else {
			while (true) {
				while (a[ps] <= pivot_value && ps < pe)
					ps++;
				if (ps == pe) {
					pivot = ps + 1;
					break;
				}
				while (a[pe] >= pivot_value && ps < pe)
					pe--;
				if (ps == pe) {
					pivot = ps;
					break;
				}
				int t = a[ps];
				a[ps] = a[pe];
				a[pe] = t;
				if (ps + 1 == pe) {
					pivot = pe;
					break;
				}
			}
		}
		a[r] = a[pivot];
		a[pivot] = pivot_value;
		return (pivot == r) ? r - 1 : pivot;
	}

	private void quicksort(int l, int r) {
		// ここを作る
		// クイックソートを実装する
		// 配列aの中身をソートする
		if (r - l <= 0)
			return;
		int pivot = this.partition(l, r);
		quicksort(l, pivot);
		quicksort(pivot + 1, r);
	}

	public void sort() {
		quicksort(0, a.length - 1);
	}

	public static void main(String[] args) {
		String file1 = "sorted2.txt";
		String file2 = "rand2_result_quick.txt";

		QuickSort qs = new QuickSort(file1);
		qs.sort();
		qs.output(file2);
	}
}
