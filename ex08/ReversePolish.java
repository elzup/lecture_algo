package ex08;

import java.util.Deque;
import java.util.LinkedList;


public class ReversePolish {
	// ここを作る スタックを作成する
	public static Deque<String> stack = new LinkedList<String>();
//	public static Deque<ReversePolish> stack = new LinkedList<ReversePolish>();

	private String label;
	private ReversePolish left;
	private ReversePolish right;

	public ReversePolish(String label, ReversePolish left, ReversePolish right) {
		this.label = label;
		this.left = left;
		this.right = right;
	}

	public void printNode() {
		printNode("");
	}

	public void printNode(String prefix) {
		if (right != null) {
			right.printNode(prefix + "\t");
		}
		System.out.println(prefix + this);
		if (left != null) {
			left.printNode(prefix + "\t");
		}
	}

	public String toString() {
		return "[" + label + "]";
	}

	public int result() {
		// ここを作る
		return Integer.parseInt(stack.pop());
	}

	public void calc(String label) {
		// ここを作る
		// なぞったノードで演算を行う
		// ノードのlabelが演算子であれば・・・
		// ノードのlabelが数字であれば・・・
		if (label == "*" || label == "+" || label == "-") {
			int a = Integer.parseInt(stack.pop());
			int b = Integer.parseInt(stack.pop());
			switch (label) {
			case "+":
				System.out.println(a + "+" + b);
				stack.push(String.valueOf(a + b));
				break;
			case "*":
				System.out.println(a + "*" + b);
				stack.push(String.valueOf(a * b));
				break;
			case "-":
				System.out.println(a + "-" + b);
				stack.push(String.valueOf(a - b));
				break;
			}
		} else {
			stack.push(label);
			System.out.println(label);
		}
		System.out.println(":" + stack.getLast());
	}

	public void traversePostorder(ReversePolish n) {
		// ここを作る（帰りがけ順のなぞり）
		if (right != null)
			this.right.traversePostorder(this);
		if (left != null)
			this.left.traversePostorder(this);
		this.calc(this.label);
	}

	public static void main(String[] args) {
		ReversePolish tree =
				new ReversePolish("*", new ReversePolish("+", new ReversePolish("3", null, null), new ReversePolish(
						"5", null, null)), new ReversePolish("-", new ReversePolish("6", null, null),
						new ReversePolish("2", null, null)));
		System.out.println("数式の木");
		tree.printNode();
		tree.traversePostorder(tree);
		System.out.println("計算結果");
		System.out.println(tree.result());
	}
}
