package ex08;

public class BTNode2 {
	private String label;
	private BTNode2 left;
	private BTNode2 right;

	public BTNode2(String label, BTNode2 left, BTNode2 right) {
		// ここを作る
		this.label = label;
		this.left = left;
		this.right = right;
	}

	public void traversePreorder() {
		traversePreorder(this);
	}

	public void traverseInorder() {
		traverseInorder(this);
	}

	public void traversePostorder() {
		traversePostorder(this);
	}

	public void traversePreorder(BTNode2 n) {
		// ここを作る
		// 行きがけ順
		System.out.print(this.label + "->");
		if (left  != null) left.traversePreorder();
		if (right != null) right.traversePreorder();
	}

	public void traverseInorder(BTNode2 n) {
		// ここを作る
		// 通りがけ順
		if (left  != null) left.traverseInorder();
		System.out.print(this.label + "->");
		if (right != null) right.traverseInorder();
	}

	public void traversePostorder(BTNode2 n) {
		// ここを作る
		// 帰りがけ順
		if (left  != null) left.traversePostorder();
		if (right != null) right.traversePostorder();
		System.out.print(this.label + "->");
	}

	public static void main(String args[]) {
//		BTNode2 tree =
//				new BTNode2("A", new BTNode2("B", new BTNode2("C", null, null), new BTNode2("E", null, null)),
//						new BTNode2("D", new BTNode2("F", null, null), new BTNode2("G", null, null)));
		BTNode2 tree =
				new BTNode2("A",
					new BTNode2("B",
						new BTNode2("C", null, null),
						new BTNode2("D",
							new BTNode2("E",
								new BTNode2("G", null, null),
								null
							),
							new BTNode2("F", null, null)
						)
					),
					new BTNode2("H", null, null)
				);
		System.out.println("行きがけ順");
		tree.traversePreorder();
		System.out.println();
		System.out.println("通りがけ順");
		tree.traverseInorder();
		System.out.println();
		System.out.println("帰りがけ順");
		tree.traversePostorder();
	}
}
