package ex07;

import java.io.File;

public class PrintDirectory {

	public static void printDir(File dir) {;
		File file = new File(dir.getPath());
		File[] nodes = file.listFiles();
		if (nodes == null) return;
		for (File f: nodes) {
			System.out.println(f.getPath());
			printDir(f);
		}
	}

	public static void main(String... args) {
		String path = ".";
		File dir = new File(path);
		printDir(dir);
	}
}
