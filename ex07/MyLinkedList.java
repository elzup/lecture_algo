package ex07;

public class MyLinkedList <T>{
	private Element head;
	private Element tail;


	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public int size() {
		Element p = head;
		int s = 0;
		while (p != null) {
			p = p.getNext();
			s++;
		}
		return s;
	}

	public void addFirst(T val) {
		if (head == null) {
			head = new Element(val);
			tail = head;
			return;
		} else {
			Element h = head;
			head = new Element(val);
			h.setPrevious(head);
			head.setNext(h);
		}
	}

	public void addLast(T str) {
		if (head == null) {
			head = new Element(str);
			tail = head;
			return;
		} else {
			Element t = tail;
			tail = new Element(str);
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
			Element p = head;
			int i = 0;
			while(i != index) {
				p = p.getNext();
			}
			p = p.getPrevious();
			Element newE = new Element(str);
			Element n = p.getNext();
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
			Element target = head;
			head = null;
			tail = null;
			return (T) target.getData();
		}
		Element h = head;
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
			Element target = head;
			head = null;
			tail = null;
			return (T) target.getData();
		}
		Element t = tail;
		tail = t.getPrevious();
		tail.setNext(null);
		return (T) t.getData();
	}

	public T remove(int index) {
		if (index < 0 || index > size()) {
			System.out.println("インデックスが範囲外です。");
			return null;
		}
		if (index == 0 ) {
			return removeFirst();
		} else if (index == size() - 1) {
			return removeLast();

		}
		Element p = head;
		int i = 0;
		while(i != index) {
			i++;
			p = p.getNext();
		}
		Element target = p;
		p.getPrevious().setNext(p.getNext());
		p.getNext().setPrevious(p.getPrevious());
		p = null;
		return (T) target.getData();
	}

	public boolean contains(T str) {
		if (head ==null) {
			System.out.println("null");
			return false;
		}
		Element p = head;
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
       Element p = head;
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
       Element p = tail;
       while(p != null) {
          System.out.print(p + " -> ");
          p = p.getPrevious();
       }
       System.out.println("null");
   }

	public static void main(String...args) {
		// いろいろと試す
		System.out.println("リストの生成");
		MyLinkedList list = new MyLinkedList();
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
	}
}
