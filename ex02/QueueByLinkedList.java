package ex02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByLinkedList {
	public static void main(String...args) {
		Deque<String> queue = new LinkedList<String>();
		String[] names = {"Alice", "Bob", "Charlie", "Diana", "Elmo", "Fred"};
		for(String n : names) {
			queue.offerFirst(n);					//配列の先頭(Top)に順番に要素を追加する
			System.out.println("\noffer :" + n);
			System.out.println(queue);
		}
		for(int i = 0; i < queue.size();) {
			String poll = queue.pollLast();			//配列の末尾(bottom)をpollし、返り値（pollした値)を受け取っておく(printするため)
			System.out.println("\npoll :" + poll);
			System.out.println(queue);
		}
	}
}
