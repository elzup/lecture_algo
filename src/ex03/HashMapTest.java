package ex03;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String... args) {
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


		showEntry(hm);
		showValues(hm);
		showKeys(hm);
	}

	public static void showEntry(Map<String, String> map) {
		System.out.println("【Entry list】");
		for(Map.Entry<String, String> e: map.entrySet())
			System.out.println(e.getKey() + " => " + e.getValue());
		System.out.println();
	}

	public static void showValues(Map map) {
		System.out.println("【Vlueslist】");
		for( Object o : map.values())
			System.out.println(o);
		System.out.println();
	}

	public static void showKeys(Map map) {
		System.out.println("【key list】");
		for (Object o : map.keySet())
			System.out.println(o);
		System.out.println();
	}
}
