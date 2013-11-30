package ex05;

import java.util.LinkedList;

public class SortedList {
	private LinkedList<Integer> list = null;
	public SortedList() {
		list = new LinkedList<Integer>();
	}

	private void show() {
		for(int n : this.list) {
			System.out.print("\t" + n);
		}
		System.out.println();
	}

	public void add(int value) {
//		if(list.get(0) == null && list.add(value))return;

		int i = 0;
		while(this.list.size() > i&& this.list.get(i) < value)i++;
		list.add(i, value);
	}

	public static void main(String[] args) {
	      SortedList myList = new SortedList();
	      myList.show();
	      myList.add(4);
	      myList.show();
	      myList.add(2);
	      myList.show();
	      myList.add(3);
	      myList.show();
	      myList.add(1);
	      myList.show();
	      myList.add(5);
	      myList.show();
	      myList.add(2);
	      myList.show();
	}
}
