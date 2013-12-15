package ex12;


public class InsertionSort extends Sort {
	private final int n = 50000;
	private int[] a = new int[n];

	public static String FILE_PATH = "src/ex12/data/";

	public InsertionSort(String filename) {
		super (filename, FILE_PATH);
	}

	public void sort() {
		// ここを作る
		// 挿入ソートを実装する
		// 配列arrayの中身をソートする
		for (int i = 1; i < n; i++) {
			int j = i;
			int t = a[i];
			while (j > 0 && a[j - 1] > t) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = t;
		}
	}

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "rand2_result_ins.txt";

		InsertionSort is = new InsertionSort(file1);
		is.sort();
		is.output(file2);
		System.out.println("end");
	}
}
