package ex12;

public class TestSort {
	public static void main(String[] args) {
		long start, stop;
		String file1 = "rand2.txt";
		String file2 = "sorted2.txt";
		String file3 = "reverse2.txt";
		String file4 = "same2.txt";

		// ここを作る
		// 各ファイルに対して，各ソートアルゴリズムを実行する
		// 各アルゴリズムでソートする際に，その処理時間を測定する

		// ここに処理時間を計測する処理を書く
		String[] filenames = "rand2.txt,reverse2.txt,sorted2.txt,same2.txt".split(",");

		for (String filename : filenames) {
			System.out.println(filename + "のソート");
			//------------------- bubbleSort -------------------//
			start = System.currentTimeMillis();
			BubbleSort bs = new BubbleSort(filename);
			bs.sort();
			stop = System.currentTimeMillis();
			System.out.printf("%-10s：%5d[ms]\n", "バブルソート",(stop - start));

			//------------------- selectionSort -------------------//
			start = System.currentTimeMillis();
			SelectionSort ss = new SelectionSort(filename);
			ss.sort();
			stop = System.currentTimeMillis();
			System.out.printf("%-10s：%5d[ms]\n", "選択ソート",(stop - start));

			//------------------- insertionSort -------------------//
			start = System.currentTimeMillis();
			InsertionSort is = new InsertionSort(filename);
			is.sort();
			stop = System.currentTimeMillis();
			System.out.printf("%-10s：%5d[ms]\n", "挿入ソート",(stop - start));
		}
	}
}
