package ex03;

import java.util.HashMap;
import java.util.Scanner;

public class WordSearcher {

	public static void main(String...args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		String[][] datas = {
				{ "tomato", "トマト" },
				{ "strawberry", "苺" },
				{ "orange", "蜜柑" },
				{ "onion", "玉葱" },
				{ "apple", "林檎" },
				{ "banana", "バナナ" }
		};
		for (String[] d : datas) {
			hm.put(d[0], d[1]);
		}

		System.out.println("英単語を入力して下さい。");
		Scanner sc = new Scanner(System.in);
		while(true) {
			String input = sc.nextLine();
			if(input.equals("")) break;
			String message = (hm.containsKey(input)) ?
				"<" + input + ">の意味をは[" + hm.get(input) + "]です。":
				"辞書に<" + input + ">という単語はありません。";
			System.out.println(message);
		}
	}
}
