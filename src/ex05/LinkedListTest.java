package ex05;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {


	public static void main(String...args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] nums = {6, 3, 5, 7, 2, 1, 4, 10, 9, 8};
		for(int n : nums) list.add(n);
		show(list);

		list.addFirst(11);
		show(list);

		list.addLast(0);
		show(list);

		list.add(4, 12);
		show(list);

		showExist(list, 3);
		showExist(list, 13);

		showIndex(list, 5);

		showWhere(list, 4);

		show(list);

		list.remove(7);
		show(list);

		list.remove(6);
		list.add(6, -1);
		show(list);
	}

	static void showExist(Collection co, Object o) {
		System.out.println(o + "があり" + ((co.contains(o)) ? "ました。": "ませんでした。"));
	}

	static void showIndex(Collection co, int i) {
		Object[] oa = (co.toArray());
		System.out.println(((int)i + 1) + "番目(インデックス" + i + ")の要素は" + oa[i]);
	}

	static void showWhere(List li, Object o) {
		int i = li.indexOf(o);
		System.out.println("要素" + o + "は" + i + "インデックスにあります");
	}

	static void show(Collection co) {
		for(Object o: co) {
			System.out.print("\t" + o);
		}
		System.out.println();
	}
}