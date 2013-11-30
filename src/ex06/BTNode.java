package ex06;

public class BTNode {

	private String label;
	private BTNode left;
	private BTNode right;

	private static String PREFIX_SHIFT = "\t";

	public BTNode(String label, BTNode left, BTNode right) {
		this.label = label;
		this.left = left;
		this.right = right;
	}

	public void printNode() {
		printNode("");
	}

	public void printNode(String prefix) {
		if (this.left != null)
			left.printNode(prefix + PREFIX_SHIFT);
		System.out.println(prefix + this);
		if (this.right != null)
			right.printNode(prefix + PREFIX_SHIFT);
	}

	public BTNode search(String name) {
		if ( name == this.label) return this;
		else if ( this.left != null && this.left.search(name) != null) return this.left;
		else if ( this.right != null && this.right.search(name) != null) return this.right;
		return null;
	}

	@Override
	public String toString() {
		return "[" + label + "]";
	}

	public static void main(String... args) {
		BTNode tree =
				new BTNode("A", new BTNode("B", new BTNode("C", null, null), new BTNode("E", null, null)), new BTNode(
						"D", new BTNode("F", null, null), new BTNode("G", null, null)));
		tree.printNode();
		System.out.println("Dを探す: " + tree.search("D"));
		System.out.println("Zを探す: " + tree.search("Z"));

		BTNode tree02 = new BTNode("_Z", tree,
				new BTNode("ZA",
				new BTNode("ZB", 
				new BTNode("ZC", null, null), null),
				new BTNode("ZD", null,
						new BTNode("ZG", null, null))));
		tree02.printNode();
	}
}
