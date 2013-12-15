package ex12;


public class BubbleSort extends Sort {
	private final int n = 50000;
	private int[] a = new int[n];

	public static String FILE_PATH = "src/ex12/data/";

	public BubbleSort(String filename) {
		// ここを作る
		// ファイル名を引数とする
		// ファイルを開いて全て読み込んで配列arrayに入れる
		super (filename, FILE_PATH);
	}

	public void sort() {
		// ここを作る
		// バブルソートを実装する
		// 配列arrayの中身をソートする
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i;j--) {
				if (a[j] < a[j - 1]) {
					int t = a[j];
					a[j] = a[j - 1];
					a[j - 1] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "rand2_result_bub.txt";

		BubbleSort bs = new BubbleSort(file1);
		bs.sort();
		bs.output(file2);
		System.out.println("end");
	}
}
