package ex11;

public class BinarySearchTree {
	private class BTNode {
		Integer data;
		BTNode left;
		BTNode right;

		public BTNode(Integer data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public void printNode() {
			printNode("");
		}

		public void printNode(String prefix) {
			if (right != null) {
				right.printNode(prefix + "\t");
			}
			System.out.println(prefix + this.data);
			if (left != null) {
				left.printNode(prefix + "\t");
			}
		}

		public void putOn(BTNode n) {
			this.data = n.data;
			this.left = n.left;
			this.right = n.right;
		}
	}

	private BTNode root;

	public BinarySearchTree() {
		root = null;
	}

	public BTNode search(Integer key) {
		// keyで示されるノードを探索する
		// keyが見つかればそのノードを返し，
		// 見つからなければnullを返す
		BTNode n = this.root;
		while (true) {
			if (n == null)
				return null;
			int r = key.compareTo(n.data);
			if (r == -1)
				n = n.left;
			else if (r == 1)
				n = n.right;
			else
				return n;
		}
	}

	public BTNode add(Integer key) {
		// keyを二分探索木に追加する
		// ここを作成する
		// どこに追加するか
		// 左部分木に追加するか
		// 右部分木に追加するか

		BTNode newNode = new BTNode(key);
		BTNode n = this.root;
		if (n == null) {
			this.root = newNode;
			return newNode;
		}

		BTNode pare;
		int r;
		do {
			r = key.compareTo(n.data);
			pare = n;
			if (r == -1)
				n = n.left;
			else if (r == 1)
				n = n.right;
			else
				return null;
		} while (n != null);

		if (r == -1)
			pare.left = newNode;
		else
			pare.right = newNode;

		return newNode;
	}

	public boolean remove(Integer key) {
		// keyを二分探索木から探し，あれば削除する
		// ここを作成する
		// 1. 子を持たない場合
		// 2. 子を1つだけ持つ場合
		// 3. 左右の子を持つ場合（右部分木で最小のノードで置き換える）

		BTNode n = this.root;
		if (n == null)
			return false;

		BTNode pare = null; // storage Node of one level upper from target
		int r;
		do {
			if (n == null)
				return false;
			r = key.compareTo(n.data);
			if (r != 0)
				pare = n;
			if (r == -1)
				n = n.left;
			else if (r == 1)
				n = n.right;
		} while (n.data != key);

		if (n.left != null && n.right != null) { //3
			BTNode nodeMin = removeMin(n, null);
			BTNode leftNode = n.left;
			if (r == -1) {
				n.data = nodeMin.data;
			}
			n.left = leftNode;

		} else { //1,2
			if (r == -1) {
				if (n.left == null)
					pare.left = n.right;
				else
					pare.left = n.left;
			} else {
				if (n.left == null)
					pare.right = n.right;
				else
					pare.right = n.left;
			}
		}
		return true;
	}

	private BTNode removeMin(BTNode parent, BTNode p) {
		// 削除すべきノードが左右の子を持っているときに
		// 最小のノードを探し出すメソッド
		// ここを作成する
		BTNode n = parent.right;
		BTNode pare = null;
		do {
			pare = n;
			n = n.left;
		} while (n.left != null);

		pare.left = n.right;
		return n;
	}

	public void printNode() {
		// it's debug
		if (this.root == null) {
			System.out.println("rootが空です");
			return;
		}
		root.printNode("");

		// 追加分: 課題2
		System.out.println("最小の要素:" + this.min().data);
		System.out.println("最大の要素:" + this.max().data);
		// 追加分: 課題3
		this.traverse();
	}

	public BTNode min() {
		BTNode n = this.root;
		while (n.left != null)
			n = n.left;
		return n;
	}

	public BTNode max() {
		BTNode n = this.root;
		while (n.right != null)
			n = n.right;
		return n;
	}

	public void traverse() {
		this.traverse(this.root);
		System.out.println();
	}
	public void traverse(BTNode n) {
		if (n.left  != null) this.traverse(n.left );
		System.out.print(n.data + "->");
		if (n.right != null) this.traverse(n.right);
	}

	public static void main(String[] args) {
		System.out.println("二分探索木の作成");
		BinarySearchTree bst = new BinarySearchTree();

		bst.add(13);
		bst.add(5);
		bst.add(21);
		bst.add(15);
		bst.add(7);
		bst.add(2);
		bst.add(6);

		bst.printNode();

		BTNode result;
		System.out.print("ノード3を探索:");
		result = bst.search(3);
		if (result != null) {
			System.out.println(result.data);
		} else {
			System.out.println("探索失敗");
		}

		System.out.print("ノード5を探索:");
		result = bst.search(5);
		if (result != null) {
			System.out.println(result.data);
		} else {
			System.out.println("探索失敗");
		}

		System.out.println("ノード8を追加");
		bst.add(8);
		bst.printNode();

		System.out.println("子を1つだけ持ったノードの削除");
		BinarySearchTree bst2 = new BinarySearchTree();

		bst2.add(9);
		bst2.add(14);
		bst2.add(5);
		bst2.add(3);
		bst2.add(4);
		bst2.add(1);
		bst2.add(14);
		bst2.printNode();

		System.out.println("ノード5を削除");
		if (bst2.remove(5)) {
			System.out.println("削除成功");
		}
		bst2.printNode();

		System.out.println("子を2つ持ったノードの削除");
		BinarySearchTree bst3 = new BinarySearchTree();

		bst3.add(20);
		bst3.add(23);
		bst3.add(29);
		bst3.add(7);
		bst3.add(18);
		bst3.add(4);
		bst3.add(2);
		bst3.add(5);
		bst3.add(10);
		bst3.add(15);
		bst3.printNode();

		System.out.println("ノード7を削除");
		if (bst3.remove(7)) {
			System.out.println("削除成功");
		}
		bst3.printNode();
	}
}
