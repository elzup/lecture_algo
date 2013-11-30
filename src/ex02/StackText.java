package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class StackText {
	public static void main(String... args) throws IOException {
		String filename_input = "./algo/ex02/input.txt";
		String filename_output = "./algo/ex02/output.txt";
		FileInputStream fi = new FileInputStream(filename_input);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fi, "MS932"));

		Deque<String> queue = new LinkedList<String>();

		String line;
		while ((line = bf.readLine()) != null) {
			System.out.println(line);
			queue.offerFirst(line);
		}

		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename_output)));
		while (queue.size() > 0) {
			String poll = queue.pollLast();
			System.out.println(poll);
			writer.println(poll);
		}
		writer.close();
	}

}
