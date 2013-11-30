package ex04;

public class Factorial2 {
	public static final int LOOP_NUMBER = 5;
	public static int factorial(int x) {
		if(x <= 1)return 1;
		return x * factorial(x - 1);
	}
	public static void main(String...args) {
		System.out.println("再帰を使って階乗を求めます。(to " + (Factorial2.LOOP_NUMBER) + ")");
		for ( int i = 0; i <= Factorial1.LOOP_NUMBER; i++) {
			System.out.println(i + "の階乗は" + factorial(i));
		}
	}
}
