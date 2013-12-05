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



		start = System.currentTimeMillis();
		// ここに処理時間を計測する処理を書く
		stop = System.currentTimeMillis();
		System.out.println((stop - start) + "[ms]");
	}
}
