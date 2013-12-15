package ex12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Sort {
	protected int n = 50000;
	protected int[] a = new int[n];

	protected String file_path;

	public Sort(String filename, String filepath) {
		this.file_path = filepath;
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(new File(file_path + filename)));
			String k;
			for (int i = 0; i < n; i++) {
				k = br.readLine();
				this.a[i] = Integer.parseInt(k);
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + "が見つかりません。");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public abstract void sort();

	public void output(String filename) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(file_path + filename))));
			for (int i: this.a) {
				pw.println(i);
			}
			pw.close();
		} catch (IOException e) {
			// TODO catch block
			e.printStackTrace();
		}
	}
}
