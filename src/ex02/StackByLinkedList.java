package ex02;

import java.util.Deque;
import java.util.LinkedList;

public class StackByLinkedList {
	public static void main(String...args) {
		Deque<String> stack = new LinkedList<String>();
		String[] names = {"Alice", "Bob", "Charlie", "Diana", "Elmo", "Fred"};
		for(String n : names) {
			stack.addLast(n);
			System.out.println("\nadd:" + n);
			System.out.println(stack);
		}
		for(int i = 0; i < stack.size();) {
			String remove = stack.removeLast();
			System.out.println("\nremove" + remove);
			System.out.println(stack);
		}
	}
}
