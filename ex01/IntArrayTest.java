package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntArrayTest {
	public static void main(String... arg) {
		System.out.println("配列の大きさを入れて下さい。");
		int[] numbers = null;
		Scanner sc = new Scanner(System.in);
		try {
			int n = sc.nextInt();
			if (n <= 0) {
				System.out.println("0より大きな値を入れて下さい。");
				System.exit(0);
			}

			numbers = new int[n];
			System.out.println("整数値を" + n + "個入れて下さい。");
			for (int i = 0; i < n; i++) {
				System.out.print(i + 1 + "番目: ");
				numbers[i] = sc.nextInt();
			}

		} catch (InputMismatchException e) {
			System.out.println("整数の形式が違います。");
			e.printStackTrace();
			System.exit(0);
		}

		int sum = 0;
		System.out.println("入力された値は");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print("," + numbers[i]);
			sum += numbers[i];
		}
		System.out.println("\n合計は" + sum);
		System.out.println("平均は" + (float)((float)sum / numbers.length));
	}
}
