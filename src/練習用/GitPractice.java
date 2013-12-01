package 練習用;

import java.util.Random;

public class GitPractice {

	public static void main(String... args) throws InterruptedException {
		//Performance calc start
		long time_start = System.currentTimeMillis();
		long mem_start = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		//

		System.out.println("自由に変更していいよ");
		Thread.sleep(10);

		//Recursive(4);

		MatrixMultiple mm = new MatrixMultiple();
		float[][] m1 = MatrixMultiple.createRndMatrix(3, 4);
		float[][] m2 = MatrixMultiple.createRndMatrix(3, 3);
		MatrixMultiple.printMatrix(m1);
		MatrixMultiple.printMatrix(m2);
		mm.addMatrix(m1);
		mm.addMatrix(m2);
		MatrixMultiple.printMatrix(mm.multiple(), "%-3.2f");





		//Performance calc end
		long time_end = System.currentTimeMillis();
		long mem_end = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println();
		System.out.printf("実行時間     : %d ms\n", (time_end - time_start));
		System.out.printf("メモリ使用量 : %d \n", (mem_end - mem_start));
	}

	public static String FIX = ">";

	public static void Recursive(int n) {
		if (n == 0)
			return;
		for (int i = 0; i < n; i++) {
			System.out.print(FIX);
			GitPractice.Recursive(n - 1);
		}
		System.out.println();
	}
}















/* --------------------------------------------------------- *
 *     MatrixMultipleClass
 * --------------------------------------------------------- */
class MatrixMultiple {
	private float[][] m1;
	private float[][] m2;

	public float[][] getM1() {
		return m1;
	}
	public float[][] getM2() {
		return m2;
	}

	public MatrixMultiple() {
		this.m1 = null;
		this.m2 = null;
	}

	public MatrixMultiple(float[][] m1, float[][] m2) {
		this.setMatrix01(m1);
		this.setMatrix02(m2);
	}

	public boolean setMatrix01(float[][] m) {
		if (m1 != null) {
			System.out.println("matrix01 already initialized");
			return false;
		}
		this.m1 = m;
		return true;
	}

	public boolean setMatrix02(float[][] m) {
		if (m2 != null) {
			System.out.println("matrix02 already initialized");
			return false;
		}
		this.m2 = m;
		return true;
	}

	public boolean addMatrix(float[][] m) {
		if (this.m1 == null)
			this.setMatrix01(m);
		else if (this.m2 == null)
			this.setMatrix02(m);
		else {
			System.out.println("each matrix already setted");
			return false;
		}
		return true;
	}

	public float[][] multiple() {
		if (this.m1 == null || this.m2 == null) {
			System.out.println("matrix not setted");
			return null;
		}
		int w = this.m2[0].length;
		int h = this.m1.length;
		int len = this.m2.length;
		if (len != this.m1[0].length) {
			System.out.println("can't calc this combination");
			return null;
		}
		float[][] mr = new float[h][w];

		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				float sum = 0;
				for (int l = 0; l < len; l++)
					sum += this.m1[j][l] * this.m2[l][i];
				mr[j][i] = sum;
			}
		}

		return mr;
	}

	public void reset() {
		this.reset(null, null);
	}

	public void reset(float[][] m1, float[][] m2) {
		this.m1 = m1;
		this.m2 = m2;
	}

	public String toString() {
		String tx = "";
		String str_m1 = this.m1 != null ? String.format("%d x %d\n", m1.length, m1[0].length) : "EMPTY";
		tx += String.format("matrix1: %s", str_m1);
		String str_m2 = this.m2 != null ? String.format("%d x %d\n", m2.length, m2[0].length) : "EMPTY";
		tx += String.format("matrix2: %s", str_m2);
		return tx;
	}

	public static float[][] createRndMatrix(int w, int h) {
		float[][] mr = new float[h][w];

		Random r = new Random();
		for (int j = 0; j < h; j++)
			for (int i = 0; i < w; i++)
				mr[j][i] = r.nextFloat() * 10;

		return mr;
	}

	public static String format_material = "%.2f";
	public static void printMatrix(float[][] m) {
		printMatrix(m, format_material);
	}
	public static void printMatrix(float[][] m, String format) {
		if (m == null) {
			System.out.println("matrix is null");
			return ;
		}
		for (int j = 0; j < m.length; j++) {
			for (int i = 0; i < m[0].length; i++) {
				System.out.printf(format + ", ", m[j][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
