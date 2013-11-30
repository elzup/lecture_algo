package ex07;

public class MyLinkedList <T>{
	private Element<T> head;
	private Element<T> tail;


	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public int size() {
		Element<T> p = head;
		int s = 0;
		while (p != null) {
			p = p.getNext();
			s++;
		}
		return s;
	}

	public void addFirst(T val) {
		if (head == null) {
			head = new Element<T>(val);
			tail = head;
			return;
		} else {
			Element<T> h = head;
			head = new Element<T>(val);
			h.setPrevious(head);
			head.setNext(h);
		}
	}

	public void addLast(T str) {
		if (head == null) {
			head = new Element<T>(str);
			tail = head;
			return;
		} else {
			Element<T> t = tail;
			tail = new Element<T>(str);
			tail.setPrevious(t);
			t.setNext(tail);
		}
	}

	public void add(int index, T str) {
		if (index < 0 || index > size()) {
			System.out.println("インデックスが範囲外です。");
			return;
		}
		if (index == 0) {
			this.addFirst(str);
		} else if (index == size()) {
			this.addLast(str);
		} else {
			Element<T> p = head;
			int i = 1;
			while(i++ != index)
				p = p.getNext();
			Element<T> newE = new Element<T>(str);
			Element<T> n = p.getNext();
			newE.setNext(n);
			newE.setPrevious(p);
			p.setNext(newE);
			n.setPrevious(newE);
		}
	}

	public T removeFirst() {
		if (head == null) {
			System.out.println("消去する要素がありません。");
			return null;
		}
		if (head.getNext() == null) {
			Element<T> target = head;
			head = null;
			tail = null;
			return (T) target.getData();
		}
		Element<T> h = head;
		head = head.getNext();
		head.setPrevious(null);
		return (T) h.getData();
	}

	public T removeLast() {
		if (head == null) {
			System.out.println("消去する要素がありません。");
			return null;
		}
		if (head.getNext() == null) {
			Element<T> target = head;
			head = null;
			tail = null;
			return (T) target.getData();
		}
		Element<T> t = tail;
		tail = t.getPrevious();
		tail.setNext(null);
		return (T) t.getData();
	}

	public T remove(int index) {
		if (index == 0 )
			return removeFirst();
		else if (index == size() - 1)
			return removeLast();
		else if (this.size() == 0) {
			System.out.println("リストは空です");
			return null;
		} else if (index < 0 || index >= size()) {
			System.out.println("インデックスが範囲外です。");
			return null;
		}

		Element<T> p = head;
		int i = 1;
		while(i++ <= index)
			p = p.getNext();

		System.out.println(p + ":" + index);
//		if (p.getNext() == null)
//			return this.removeLast();

		T targetD = p.getData();
		System.out.println(p);
		p.getPrevious().setNext(p.getNext());
		p.getNext().setPrevious(p.getPrevious());
		p = null;
		return (T) targetD;
	}

	public boolean contains(T str) {
		if (head ==null) {
			System.out.println("null");
			return false;
		}
		Element<T> p = head;
		while (p != null) {
			if (p.getData() == str)return true;
			p = p.getNext();
		}
		return false;
	}

  public void print() {
       // 要素を先頭から表示
       System.out.print("リスト順: ");
       if (head == null) {
          System.out.println("null");
          return;
       }
       Element<T> p = head;
       while(p != null) {
          System.out.print(p + " -> ");
          p = p.getNext();
       }
       System.out.println("null");
    }
    public void printReverse() {
       // 要素を末尾から表示
       System.out.print("リスト逆: ");
       if (tail == null) {
          System.out.println("null");
          return;
       }
       Element<T> p = tail;
       while(p != null) {
          System.out.print(p + " -> ");
          p = p.getPrevious();
       }
       System.out.println("null");
   }

	public static void main(String...args) {
		// いろいろと試す
		System.out.println("リストの生成");
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.print();
		System.out.println("サイズ: " + list.size());
		System.out.println("dを先頭に追加");
		list.addFirst("d");
		list.print();
		System.out.println("サイズ: " + list.size());
		System.out.println("cを先頭に追加");
		list.addFirst("c");
		list.print();
		System.out.println("eを最後に追加");
		list.addLast("e");
		list.print();
		list.printReverse();
		System.out.println("bを先頭に追加");
		list.addFirst("b");
		list.print();
		System.out.println("fを最後に追加");
		list.addLast("f");
		list.print();
		list.printReverse();
		System.out.println("fが含まれているか?: " + list.contains("f"));
		System.out.println("bが含まれているか?: " + list.contains("b"));
		System.out.println("dが含まれているか?: " + list.contains("d"));
		System.out.println("zが含まれているか?: " + list.contains("z"));
		list.print();
		System.out.println("先頭を削除");
		list.removeFirst();
		list.print();
		System.out.println("最後を削除");
		list.removeLast();
		list.print();
		System.out.println("先頭を削除");
		list.removeFirst();
		list.print();
		System.out.println("最後を削除");
		list.removeLast();
		list.print();
		System.out.println("先頭を削除");
		list.removeFirst();
		list.print();
		System.out.println("0番目にdを追加");
		list.add(0, "d");
		list.print();
		System.out.println("0番目にbを追加");
		list.add(0, "b");
		list.print();
		System.out.println("2番目にfを追加");
		list.add(2, "f");
		list.print();
		System.out.println("1番目にcを追加");
		list.add(1, "c");
		list.print();
		System.out.println("3番目にeを追加");
		list.add(3, "e");
		list.print();
		System.out.println("5番目にgを追加");
		list.add(5, "g");
		list.print();
		list.printReverse();
		System.out.println("0番目を削除");
		list.remove(0);
		list.print();
		System.out.println("サイズ: " + list.size());
		System.out.println("4番目を削除");
		list.remove(4);
		list.print();
		System.out.println("1番目を削除");
		list.remove(1);
		list.print();
		System.out.println("2番目を削除");
		list.remove(2);
		list.print();
		list.printReverse();
		System.out.println("1番目を削除");
		list.remove(1);
		list.print();
		System.out.println("0番目を削除");
		list.remove(0);
		list.print();
		System.out.println("end.");

		System.out.println("------------------------");
		System.out.println("リストの生成[数字]");
		MyLinkedList<Integer> listInteger = new MyLinkedList<Integer>();
		listInteger.print();
		System.out.println("サイズ: " + listInteger.size());
		System.out.println("1を先頭に追加");
		listInteger.addFirst(1);
		listInteger.print();
		System.out.println("eを最後に追加");
		listInteger.addLast(2);
		listInteger.print();
		listInteger.printReverse();
		System.out.println("3を先頭に追加");
		listInteger.addFirst(3);
		listInteger.print();
		listInteger.printReverse();
		System.out.println("fが含まれているか?: " + listInteger.contains(2));
		System.out.println("bが含まれているか?: " + listInteger.contains(1));
		System.out.println("dが含まれているか?: " + listInteger.contains(10));
		System.out.println("zが含まれているか?: " + listInteger.contains(4));
		listInteger.print();
		System.out.println("先頭を削除");
		listInteger.removeFirst();
		listInteger.print();
		System.out.println("最後を削除");
		listInteger.removeLast();
		listInteger.print();
		System.out.println("先頭を削除");
		listInteger.removeFirst();
		listInteger.print();
		System.out.println("0番目に1を追加");
		listInteger.add(0, 1);
		listInteger.print();
		System.out.println("1番目に4を追加");
		listInteger.add(1, 4);
		listInteger.print();
		System.out.println("5番目に8を追加");
		listInteger.add(5, 8);
		listInteger.print();
		listInteger.printReverse();
		System.out.println("0番目を削除");
		listInteger.remove(0);
		listInteger.print();
		System.out.println("サイズ: " + listInteger.size());
		System.out.println("1番目を削除");
		listInteger.remove(1);
		listInteger.print();
		System.out.println("2番目を削除");
		listInteger.remove(2);
		listInteger.print();
		listInteger.printReverse();
		System.out.println("0番目を削除");
		listInteger.remove(0);
		listInteger.print();
		System.out.println("end.");
	}
}
