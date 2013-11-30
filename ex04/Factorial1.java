package ex04;

public class Factorial1 {
	public static final int LOOP_NUMBER = 5;
	public static int factorial(int x) {
		if(x <= 1) return 1;

		int sum = 1;
		for(int i = 2; i <= x; i++) {
			sum *= i;
		}
		return sum;
	}
	public static void main(String...args) {
		System.out.println("繰り返しを使って階乗を求めます。(to " + Factorial1.LOOP_NUMBER + ")");
		for ( int i = 0; i <= Factorial1.LOOP_NUMBER; i++) {
			System.out.println(i + "の階乗は" + factorial(i));
		}
	}
}
