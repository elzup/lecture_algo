package ex12;


public class SelectionSort extends Sort {
	public final int n = 50000;
	public int[] array = new int[n];

	public static String FILE_PATH = "src/ex12/data/";

	public SelectionSort(String filename) {
		super(filename, FILE_PATH);
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

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "rand2_result_sel.txt";

		SelectionSort ss = new SelectionSort(file1);
		ss.sort();
		ss.output(file2);
	}
}
