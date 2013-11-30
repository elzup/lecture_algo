package ex03;

import java.util.ArrayList;
import java.util.HashSet;

public class RedundantInteger {
	static int N = 4;
	public static void main(String...args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i <= N; i++) {
			for(int j = 0 ; j < i; j++) {
				list.add(i);
			}
		}
		System.out.println("After the adding: " + list);
		HashSet<Integer> set = new HashSet<Integer>(list);
		System.out.println("After the removing not unique: " + set);
	}
}
