package ex05;

import java.util.ArrayList;

public class SelectExample {
	public static void main(String[] args) {
		// ArrayListの生成と要素の追加
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		System.out.println("リストの要素の表示");
		for (int num : list) {
			System.out.print("\t" + num);
		}
		System.out.println();
		System.out.println("リスト内の奇数だけ残して、偶数を削除したい。");
		ArrayList<Integer> removeNums = new ArrayList<Integer>();
		for (int num : list) {
			System.out.println(num);
			if (num % 2 == 0) { // 偶数だったら
				removeNums.add(num);
				System.out.println(num + "を削除しました。");
			}
		}
		for (int num : removeNums) {
			System.out.println(num);
			list.remove(new Integer(num)); // その要素を削除
//			list.remove(list.indexOf(num)); // その要素を削除
		}
		System.out.println("削除後の結果表示");
		for (int num : list) {
			System.out.print("\t" + num);
		}
	}
}
