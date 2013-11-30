package ex04;

public class MyQueue {
	private Node head; // 先頭のノードを入れるフィールド

	public MyQueue() {
		head = null; // 最初は空っぽ
	}

	public void offer(String str) {
		if (this.head == null) {
			this.head = new Node(str);
			return;
		}
//		for(Node foot = this.head; (foot = foot.getNext()) != null || (foot))

		Node foot = this.head;
		while(foot.getNext() != null) {
			foot = foot.getNext();
		}
		foot.setNext(new Node(str));
	}

	public String peek() {
		return (this.head == null) ? null : this.head.getData();
	}

	public String poll() {
		if (this.head == null)
			return null;
		String data = this.head.getData();
		this.head = this.head.getNext();
		return data;
	}

	public void print() {
		// ノードを先頭から最後までたどってデータを表示
		System.out.print("キューの中身: ");
		print(head);
	}

	public void print(Node p) {
		// 再帰呼び出しでノードをたどってデータを表示
		if (p == null) {
			System.out.println("null");
			return;
		}
		System.out.print(p + " -> ");
		this.print(p.getNext());
	}

	public static void main(String[] args) {
		// キューを作って、いろいろやってみる
		MyQueue queue = new MyQueue();
		queue.print();
		queue.offer("abc");
		queue.print();
		queue.offer("def");
		queue.print();
		queue.offer("ghi");
		queue.print();
		queue.offer("jkl");
		queue.print();
		queue.offer("mno");
		queue.print();
		System.out.println("peek: " + queue.peek());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("peek: " + queue.peek());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("poll: " + queue.poll());
		queue.print();
		System.out.println("peek: " + queue.peek());
		queue.print();
	}
}