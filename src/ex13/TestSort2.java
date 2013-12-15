package ex13;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import ex12.BubbleSort;
import ex12.InsertionSort;
import ex12.SelectionSort;
import ex12.Sort;

public class TestSort2 {
	public static void main(String[] args) {
		long start, stop;
		String file1 = "rand2.txt";
		String file2 = "reverse2.txt";
		String file3 = "sorted2.txt";
		String file4 = "same2.txt";
		// ここを作る
		// 各ファイルに対して，各ソートアルゴリズムを実行する
		// 各アルゴリズムでソートする際に，その処理時間を測定する

		String[] filenames = {
				file1,
				file2,
				file3,
				file4,
		};
		for (String filename : filenames) {

			System.out.println(filename + "のソート");

			HashMap<String, Sort> sorts = new LinkedHashMap<String, Sort>();
			sorts.put("バブルソート"   , new BubbleSort(filename));
			sorts.put("選択ソート"     , new SelectionSort(filename));
			sorts.put("挿入ソート"     , new InsertionSort(filename));
			sorts.put("クイックソート" , new QuickSort(filename));
			sorts.put("マージソート"   , new MergeSort(filename));

			for (Entry<String, Sort> e : sorts.entrySet()) {
				String name = e.getKey();
				Sort sort = e.getValue();
				start = System.currentTimeMillis();
				sort.sort();
				stop = System.currentTimeMillis();
				System.out.printf("%10s：%5d[ms]\n", name, (stop - start));
			}
		}
	}
}
